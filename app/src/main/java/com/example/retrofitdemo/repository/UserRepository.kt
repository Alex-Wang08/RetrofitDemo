package com.example.retrofitdemo.repository

import com.example.retrofitdemo.api.UserService
import com.example.retrofitdemo.model.User
import com.example.retrofitdemo.state.UserState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class UserRepository(private val userService: UserService) {
    suspend fun getUser(login:String?): Flow<UserState<User>> {
        return flow {
            val user = userService.getUser(login?:"")
            emit(UserState.success(user))
        }.flowOn(Dispatchers.IO)
    }
}