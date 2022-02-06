package com.example.crypto.feature_coin.domain.use_case.get_coin

import com.example.crypto.core.Resource
import com.example.crypto.feature_coin.domain.model.CoinDetail
import com.example.crypto.feature_coin.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException

class GetCoinUseCase(private val repository: CoinRepository) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            val coins = repository.getCoinById(coinId)
            emit(Resource.Success(data = coins))
        }catch (e:RuntimeException){
            emit(Resource.Error(message = e.message!!))
        }

    }
    }
