package com.example.crypto.feature_coin.data.mappers

import com.example.crypto.feature_coin.data.remote.dto.CoinDetailDto
import com.example.crypto.feature_coin.data.remote.dto.CoinDto
import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.domain.model.CoinDetail

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
            isActive = is_active,
            symbol = symbol,
            description = description,
            rank = rank,
            team = teamMembers,
            tags = tags.map { it.name },

            )
    }

}