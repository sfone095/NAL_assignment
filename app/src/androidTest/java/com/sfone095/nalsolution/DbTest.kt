package com.sfone095.nalsolution

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.sfone095.nalsolution.data.AppDatabase
import com.sfone095.nalsolution.data.dao.CityDao
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@SmallTest
class DbTest {
    private lateinit var _cityDao: CityDao
    private lateinit var _db: AppDatabase

    @Before
    fun setup() {
        _db = AppDatabase.getInstance(
            ApplicationProvider.getApplicationContext()
        )
        _cityDao = _db.cityDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        if (::_db.isInitialized) {
            _db.close()
        }
    }

    @Test
    fun verify_total_records_is_272128() {
        assertEquals(272128, _cityDao.totalRecords())
    }
}