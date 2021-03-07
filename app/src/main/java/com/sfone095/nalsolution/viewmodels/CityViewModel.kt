package com.sfone095.nalsolution.viewmodels

import androidx.lifecycle.MutableLiveData
import com.sfone095.nalsolution.data.entities.City

class CityViewModel(private val data: City) {

    val item = MutableLiveData<City>().apply { value = data }
}