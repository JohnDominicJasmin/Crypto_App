package com.example.crypto.feature_coin.domain.repositories

import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(coinId:String):CoinDetail
}