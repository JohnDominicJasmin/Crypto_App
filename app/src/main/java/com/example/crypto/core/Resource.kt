package com.example.crypto.core

sealed class Resource <T> (val data:T? = null, val message:String? = null){
    class Success<T>(data:T):Resource<T>(data)
    class Error<T>(message: String, data: T? = null):Resource<T>(data,message)
    class Warning<T>(data :T? = null):Resource<T>(data)

}