package com.sfone095.nalsolution.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.sfone095.nalsolution.data.entities.City

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun pagingSource(): PagingSource<Int, City>

    @Query("SELECT COUNT(id) FROM cities")
    fun totalRecords(): Int
}