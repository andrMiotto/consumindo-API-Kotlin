package com.example.consumindoapi.repository

import com.example.consumindoapi.model.User
import com.example.consumindoapi.network.RetrofitClient

class UseRepository {

    suspend fun fetchUser(userId: Int): User?{
        val response = RetrofitClient.apiService.getUser(userId);
        return if (response.isSuccessful){
            response.body()
        }else{
            null
        }

    }



}