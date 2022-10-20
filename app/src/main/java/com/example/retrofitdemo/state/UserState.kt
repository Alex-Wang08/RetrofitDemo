package com.example.retrofitdemo.state

data class UserState<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data:T?): UserState<T>{
            return UserState(Status.SUCCESS,data,null)
        }

        fun <T> error(msg:String):UserState<T>{
            return UserState(Status.ERROR,null,msg)
        }

        fun <T> loading(): UserState<T>{
            return UserState(Status.LOADING,null,null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}