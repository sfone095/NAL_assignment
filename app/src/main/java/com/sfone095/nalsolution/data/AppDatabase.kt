package com.sfone095.nalsolution.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sfone095.nalsolution.data.dao.CityDao
import com.sfone095.nalsolution.data.entities.City

@Database(entities = [City::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao

    companion object {
        private var _db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (_db == null) {
                synchronized(AppDatabase::class) {
                    _db = Room.databaseBuilder(context, AppDatabase::class.java, "cities.db")
                            .createFromAsset("database/utopia_cities.db")
                            .build()
                }
            }

            return _db!!
        }
    }
}
