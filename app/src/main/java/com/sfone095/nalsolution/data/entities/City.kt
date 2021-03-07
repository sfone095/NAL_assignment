package com.sfone095.nalsolution.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cities")
data class City(
        @PrimaryKey @ColumnInfo(name = "id") var id: String,
        @ColumnInfo(name = "country") var country: String?,
        @ColumnInfo(name = "city") var city: String?,
        @ColumnInfo(name = "population") var population: Int?
)
