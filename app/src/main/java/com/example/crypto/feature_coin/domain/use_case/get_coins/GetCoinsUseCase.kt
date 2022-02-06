package com.example.crypto.feature_coin.domain.use_case.get_coins

import com.example.crypto.core.Resource
import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException

class GetCoinsUseCase(private val repository: CoinRepository) {

    operator fun invoke():Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(data = coins))
        }catch (e:RuntimeException){
            emit(Resource.Error(message = e.message!!))
        }
    }
    }
