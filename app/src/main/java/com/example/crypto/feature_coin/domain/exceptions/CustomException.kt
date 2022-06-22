package com.example.crypto.feature_coin.domain.exceptions

import kotlin.RuntimeException

object CustomException{
    class UnexpectedErrorException(message:String):RuntimeException(message)
    class NoInternetException(message: String):RuntimeException(message)
}
