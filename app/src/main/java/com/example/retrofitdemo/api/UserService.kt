package com.example.retrofitdemo.api

import com.example.retrofitdemo.model.User

import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{login}")
    suspend fun getUser(
        @Path("login") login: String
    ): User

}