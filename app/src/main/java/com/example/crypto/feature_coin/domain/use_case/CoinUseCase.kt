package com.example.crypto.feature_coin.domain.use_case

import com.example.crypto.feature_coin.domain.use_case.get_coin.GetCoinUseCase
import com.example.crypto.feature_coin.domain.use_case.get_coins.GetCoinsUseCase

data class CoinUseCase(
val getCoinUseCase: GetCoinUseCase,
val getCoinsUseCase: GetCoinsUseCase){

}
