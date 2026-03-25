package com.lobosmanuel.knowdatbook.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Se usa patrón Singleton (sólo existe una instancia de la DB para toda la app)
@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {

    abstract fun getBookDao(): BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        // En tu Database class
        fun getDatabase(context: Context): BookDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "book_database"
                )
                    .fallbackToDestructiveMigration() // <--- ESTO EVITA QUE SE ROMPA
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}