package com.example.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val userRepository: UserRepository):ViewModel() {
    val userData:MutableLiveData<Response<List<UserDataItem>>> = MutableLiveData()

    fun getUserData() = viewModelScope.launch {
        val response = userRepository.getUser()
        userData.postValue(loadUserData(response))
    }

    private fun loadUserData(response: Response<List<UserDataItem>>):Response<List<UserDataItem>>{
        if (response.isSuccessful && response.body() != null){
            response.body().let {
                return Response.success(it)
            }
        }
        return Response.error(response.code(), response.errorBody()!!)
    }
}