package com.example.databinding

import retrofit2.Response

class UserRepository {

    suspend fun getUser():Response<List<UserDataItem>>{
        return NetworkClient.api.getUserData()
    }

}