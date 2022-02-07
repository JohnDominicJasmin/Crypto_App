package com.example.crypto.feature_coin.presentation.ui.coin_list

import com.example.crypto.feature_coin.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)