package com.example.crypto.feature_coin.presentation.ui.coin_detail

import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coins:CoinDetail? = null,
    val error:String = ""
)