package app.minimal.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    protected fun loadMainActivity() {
        val homeBtn = findViewById<ImageButton>(R.id.home)
        homeBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    protected fun loadExtendedActivity() {
        val extendedBtn = findViewById<ImageButton>(R.id.extended)
        extendedBtn.setOnClickListener() {
            val intent = Intent(this, ExtendedActivity::class.java)
            startActivity(intent)
        }
    }

    protected fun loadInfoActivity() {
        val infoBtn = findViewById<ImageButton>(R.id.info)
        infoBtn.setOnClickListener() {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
    }

    protected fun loadHistoryActivity() {
        val historyBtn = findViewById<ImageButton>(R.id.history)
        historyBtn.setOnClickListener() {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}