package com.example.crypto.feature_main_screen.data.remote.dto

import com.example.crypto.feature_main_screen.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

