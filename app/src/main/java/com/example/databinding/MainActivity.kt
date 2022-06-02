package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databinding.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRepository = UserRepository()
        val viewModelProvider = UserViewModelProviderFactory(userRepository)
        userViewModel = ViewModelProvider(this,viewModelProvider).get(UserViewModel::class.java)


        userViewModel.getUserData()

        userViewModel.userData.observe(this, Observer { response ->
            response.body()?.let {
                initRecyclerView(it)
            }
        })
    }

    private fun initRecyclerView(userList:List<UserDataItem>){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(userList)
        binding.recyclerView.adapter = adapter
    }

}