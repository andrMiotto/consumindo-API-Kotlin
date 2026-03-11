package com.example.consumindoapi.network

import com.example.consumindoapi.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): Response<User>;

}