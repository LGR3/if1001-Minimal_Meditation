package app.minimal.meditation

import android.os.Bundle

class HistoryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        loadMainActivity()
        loadExtendedActivity()
        loadInfoActivity()
        loadHistoryActivity()
    }
}