package com.example.crypto.feature_main_screen.data.remote.dto.map

import com.example.crypto.feature_main_screen.data.remote.dto.CoinDto
import com.example.crypto.feature_main_screen.domain.model.Coin

class CoinDtoToCoin:Mapper<CoinDto, Coin> {
    override fun CoinDto.map(input: CoinDto): Coin {
        return Coin(
            id = id,
            is_active = is_active,
            name = name,
            rank = rank,
            symbol = symbol
        )
    }
}