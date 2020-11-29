package app.minimal.meditation

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class MeditationDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun insertMeditation(meditation: MeditationModel): Boolean {
        val db = writableDatabase

        val values = ContentValues()
        values.put(DBContract.MeditationEntry.COLUMN_LOCATION, meditation.location)
        values.put(DBContract.MeditationEntry.COLUMN_TIMESTAMP, meditation.timestamp)
        values.put(DBContract.MeditationEntry.COLUMN_SECONDS, meditation.seconds)
        db.insert(DBContract.MeditationEntry.TABLE_NAME, null, values)
        return true
    }

    fun getTotalSeconds(): Int {
        var total = 0
        val db = writableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery("SELECT SUM("+ DBContract.MeditationEntry.COLUMN_SECONDS  +") from " + DBContract.MeditationEntry.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            return total
        }

        if (cursor!!.moveToFirst()) {
            total = cursor.getInt(0)
        }
        cursor.close()
        return total
    }

    fun readAllMeditations(): ArrayList<MeditationModel> {
        val meditations = ArrayList<MeditationModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM " + DBContract.MeditationEntry.TABLE_NAME + " LIMIT 50;", null)
        } catch (e: SQLiteException) {
            return ArrayList()
        }

        var location: String
        var timestamp: String
        var seconds: String
        if (cursor!!.moveToFirst()) {
            while (!cursor.isAfterLast) {
                location = cursor.getString(cursor.getColumnIndex(DBContract.MeditationEntry.COLUMN_LOCATION))
                timestamp = cursor.getInt(cursor.getColumnIndex(DBContract.MeditationEntry.COLUMN_TIMESTAMP)).toString()
                seconds = cursor.getInt(cursor.getColumnIndex(DBContract.MeditationEntry.COLUMN_SECONDS)).toString()

                meditations.add(MeditationModel(location, Integer.valueOf(timestamp), Integer.valueOf(seconds)))
                cursor.moveToNext()
            }
        }
        cursor.close()
        return meditations
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Meditations.db"
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${DBContract.MeditationEntry.TABLE_NAME}"
        val SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS ${DBContract.MeditationEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${DBContract.MeditationEntry.COLUMN_LOCATION} TEXT," +
                    "${DBContract.MeditationEntry.COLUMN_TIMESTAMP} INTEGER," +
                    "${DBContract.MeditationEntry.COLUMN_SECONDS} INTEGER)"
    }
}
