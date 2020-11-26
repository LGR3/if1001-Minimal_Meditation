package app.minimal.meditation

import android.os.Bundle

class InfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        loadMainActivity()
        loadExtendedActivity()
        loadHistoryActivity()
    }
}