package com.sfone095.nalsolution.viewmodels

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sfone095.nalsolution.data.dao.CityDao

class MainViewModel(cityDao: CityDao): ViewModel() {

    val pager = Pager(config = PagingConfig(30)) {
        cityDao.pagingSource()
    }
}