package app.minimal.meditation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class HistoryActivity : BaseActivity() {
    private lateinit var meditationDBHelper : MeditationDBHelper
    private var parentLinearLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        meditationDBHelper = MeditationDBHelper(this)
        parentLinearLayout = findViewById(R.id.parent_linear_layout)
        loadMainActivity()
        loadExtendedActivity()
        loadInfoActivity()
        updateTotalHours()
        fillHistory()
    }

    private fun updateTotalHours() {
        val total = meditationDBHelper.getTotalSeconds()
        val totalHours: TextView = findViewById(R.id.totalHours)
        val hours = total.toDouble() / 3600
        totalHours.text = String.format("%.2f", hours)
    }

    private fun fillHistory() {
        val allMeditations = meditationDBHelper.readAllMeditations()
        val reversedMeditations = allMeditations.reversed()
        reversedMeditations.forEach {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView: View = inflater.inflate(R.layout.history_row, null)
            parentLinearLayout!!.addView(rowView, parentLinearLayout!!.childCount)

            val location = findViewById<TextView>(R.id.location)
            val seconds = findViewById<TextView>(R.id.seconds)
            val timestamp = findViewById<TextView>(R.id.timestamp)

            val datetime = Date(it.timestamp.toLong() * 1000)
            val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val formattedDate = formatter.format(datetime)

            if (it.seconds == 300) {
                seconds.textSize = 22.toFloat()
                seconds.setTextColor(-0xff0100)
            }

            location.text = it.location
            seconds.text = "${it.seconds}s"
            timestamp.text = formattedDate

            location.id = -1
            seconds.id = -1
            timestamp.id = -1

        }
    }
}