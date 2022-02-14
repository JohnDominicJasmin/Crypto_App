package com.example.crypto.feature_coin.data.mappers

import com.example.crypto.feature_coin.data.remote.dto.CoinDetailDto
import com.example.crypto.feature_coin.data.remote.dto.CoinDto
import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.domain.model.CoinDetail
import timber.log.Timber

object CoinMapper {


    fun CoinDto.toCoin(): Coin {
        return Coin(
            id = id,
            is_active = is_active,
            name = name,
            rank = rank,
            symbol = symbol
        )
    }


    fun CoinDetailDto.toCoinDetail(): CoinDetail {
        return CoinDetail(
            coinId = id,
            name = name,
            isActive = isActive,
            symbol = symbol,
            description = description,
            rank = rank,
            team = team,
            tags = tags?.map { it.name },

            )
    }

}