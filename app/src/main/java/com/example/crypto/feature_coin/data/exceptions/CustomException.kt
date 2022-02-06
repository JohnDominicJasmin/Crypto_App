package com.example.crypto.feature_coin.data.exceptions

import kotlin.RuntimeException

object CustomException{
    class UnexpectedErrorException(message:String):RuntimeException(message)
    class NoInternetException(message: String):RuntimeException(message)
}
