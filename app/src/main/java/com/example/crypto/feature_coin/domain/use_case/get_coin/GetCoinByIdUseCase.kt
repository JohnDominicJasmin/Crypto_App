package com.example.crypto.feature_coin.domain.use_case.get_coin

import com.example.crypto.common.Resource
import com.example.crypto.feature_coin.domain.model.CoinDetail
import com.example.crypto.feature_coin.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException

class GetCoinByIdUseCase(private val repository: CoinRepository) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(data = coins))
        }catch (e:RuntimeException){
            emit(Resource.Error<CoinDetail>(message = e.message!!))
        }

    }
    }
