package com.sfone095.nalsolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sfone095.nalsolution.adapter.CitiesAdapter
import com.sfone095.nalsolution.databinding.ActivityMainBinding
import com.sfone095.nalsolution.viewmodels.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val _vm: MainViewModel by inject()
    private var _binding: ActivityMainBinding? = null
    private val _adapter = CitiesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(_binding?.root)

        setupViews()
        getCities()
    }

    private fun setupViews() {
        _binding?.apply {
            rcvCities.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                adapter = _adapter
            }
        }
    }

    private fun getCities() {
        lifecycleScope.launch {
            _vm.pager.flow.collect {
                _adapter.submitData(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}