package com.sfone095.nalsolution.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sfone095.nalsolution.data.entities.City
import com.sfone095.nalsolution.databinding.RcvItemBinding
import com.sfone095.nalsolution.viewmodels.CityViewModel

class CitiesAdapter: PagingDataAdapter<City, RecyclerView.ViewHolder>(CITY_DIFF) {

    companion object {
        private val CITY_DIFF = object : DiffUtil.ItemCallback<City>() {
            override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CityViewHolder)?.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RcvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CityViewHolder(binding)
    }

    class CityViewHolder(private val binding: RcvItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(city: City) {
            binding.apply {
                vm = CityViewModel(city)

                executePendingBindings()
            }
        }
    }
}