package com.example.databinding

import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    suspend fun getUserData():Response<List<UserDataItem>>

}