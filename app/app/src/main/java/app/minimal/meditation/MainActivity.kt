package app.minimal.meditation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : BaseActivity() {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var currentLocation: String
    private val permissionCode = 101
    private lateinit var meditationDBHelper : MeditationDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meditationDBHelper = MeditationDBHelper(this)
        fusedLocationProviderClient =  LocationServices.getFusedLocationProviderClient(this@MainActivity)
        fetchLocation()

        loadMainActivity()
        loadExtendedActivity()
        loadInfoActivity()
        loadHistoryActivity()
    }

    private fun fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permissionCode)
            return
        }
        val geo = Geocoder(applicationContext)
        val task = fusedLocationProviderClient.lastLocation
        task.addOnSuccessListener { loc ->
            if (loc != null) {
                val location_list = geo.getFromLocation(
                    loc.latitude, loc.longitude, 1
                )
                val city: String = location_list[0].locality
                val state: String = location_list[0].adminArea
                val country: String = location_list[0].countryName
                currentLocation = String.format("%s, %s, %s", city, state, country)
            }
        }
    }

    fun startTimer(view: View) {
        val startBtn: Button = findViewById(R.id.start_btn)
        val startStr : String = getString(R.string.start_button)
        if (startBtn.text != startStr) {
            startBtn.text = startStr
        } else {
            var counter = 60
            val currentTimestamp = System.currentTimeMillis() / 1000
            startBtn.isEnabled = false;
            object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    startBtn.text = counter.toString()
                    counter--
                }
                override fun onFinish() {
                    val endStr: String = getString(R.string.end_time)
                    startBtn.text = endStr
                    meditationDBHelper.insertMeditation(
                        MeditationModel(
                            location = currentLocation,
                            timestamp = currentTimestamp.toInt(),
                            seconds = 60
                        )
                    )
                    startBtn.isEnabled = true;
                }
            }.start()
        }
    }
}