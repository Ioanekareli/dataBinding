package com.example.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("users")
fun bindUsers(view:RecyclerView,users:List<UserDataItem>?){
    val adapter = view.adapter as RecyclerAdapter
    adapter.usersList
}