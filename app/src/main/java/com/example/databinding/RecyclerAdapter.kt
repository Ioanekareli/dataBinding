package com.example.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.databinding.UserDataItemBinding

class RecyclerAdapter(var usersList:List<UserDataItem>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: UserDataItemBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(users:UserDataItem){
            binding.users = users
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UserDataItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = usersList[position]
        holder.onBind(userData)
    }

    override fun getItemCount(): Int = usersList.size

}