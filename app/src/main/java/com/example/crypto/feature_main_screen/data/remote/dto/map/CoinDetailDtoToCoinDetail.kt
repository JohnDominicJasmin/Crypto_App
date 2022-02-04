package com.example.crypto.feature_main_screen.data.remote.dto.map

import com.example.crypto.feature_main_screen.data.remote.dto.CoinDetailDto
import com.example.crypto.feature_main_screen.domain.model.CoinDetail

class CoinDetailDtoToCoinDetail: Mapper<CoinDetailDto, CoinDetail>{
    override fun CoinDetailDto.map(input: CoinDetailDto): CoinDetail {

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
