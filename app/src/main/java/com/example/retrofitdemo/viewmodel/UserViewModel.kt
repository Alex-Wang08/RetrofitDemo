package com.example.retrofitdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdemo.api.ApiFactory
import com.example.retrofitdemo.api.UserService
import com.example.retrofitdemo.model.User
import com.example.retrofitdemo.repository.UserRepository
import com.example.retrofitdemo.state.Status
import com.example.retrofitdemo.state.UserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlin.math.log

class UserViewModel : ViewModel() {
    private val repository = UserRepository(ApiFactory.create(UserService::class.java))
    val userState = MutableStateFlow(
        UserState<User>(
            Status.LOADING,
            null, ""
        )
    )


    fun getUser(login:String?) {
        userState.value = UserState.loading()
        viewModelScope.launch {
            repository.getUser(login)
                .catch {
                    userState.value=UserState.error(it.message.toString())
                }
                .collect{
                    userState.value = UserState.success(it.data)
                }
        }
    }


}