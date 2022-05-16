package com.sajjad.ecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sajjad.ecommerceapp.databinding.DashboardItemBinding
import com.sajjad.ecommerceapp.models.DashboardItem
import com.sajjad.ecommerceapp.models.dashboardItemList

class DashboardItemAdapter : RecyclerView.Adapter<DashboardItemAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(val binding: DashboardItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(item : DashboardItem){
                binding.item = item
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = DashboardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DashboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(dashboardItemList.get(position))
    }

    override fun getItemCount()= dashboardItemList.size
}