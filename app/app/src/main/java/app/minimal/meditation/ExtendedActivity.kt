package app.minimal.meditation

import android.os.Bundle

class ExtendedActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended)

        loadMainActivity()
        loadExtendedActivity()
        loadInfoActivity()
        loadHistoryActivity()
    }
}