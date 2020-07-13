package com.example.determinacion.inventario

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pedroroig.architectureexamplecondinginflow.utils.subscribeOnBackground

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var instance: NoteDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): NoteDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, NoteDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: NoteDatabase) {
            val noteDao = db.noteDao()
            subscribeOnBackground {
                noteDao.insert(Note("Producto 1", "001", 34, 13.25,25.99 ,))
                noteDao.insert(Note("Producto 2", "002", 25,4.0,7.00))
                noteDao.insert(Note("Producto 3", "003", 12,23.99, 34.67))

            }
        }
    }



}