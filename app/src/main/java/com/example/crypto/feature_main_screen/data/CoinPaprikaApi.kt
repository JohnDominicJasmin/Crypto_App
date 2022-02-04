package com.example.crypto.feature_main_screen.data

import com.example.crypto.feature_main_screen.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

}