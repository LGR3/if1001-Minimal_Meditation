package app.minimal.meditation

import android.provider.BaseColumns

object DBContract {
    class MeditationEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "meditations"
            val COLUMN_LOCATION = "location"
            val COLUMN_TIMESTAMP = "timestamp"
            val COLUMN_SECONDS = "seconds"
        }
    }
}