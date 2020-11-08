package app.minimal.meditation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startTimer(view: View) {
        var counter = 0
        val startBtn: Button = findViewById(R.id.start_btn)
        startBtn.isEnabled = false;
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                startBtn.text = counter.toString()
                counter++
            }
            override fun onFinish() {
                val endStr: String = getString(R.string.end_time)
                startBtn.text = endStr
            }
        }.start()
    }
}