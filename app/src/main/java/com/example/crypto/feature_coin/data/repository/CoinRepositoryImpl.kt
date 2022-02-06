package com.example.crypto.feature_coin.data.repository

import com.example.crypto.core.Resource
import com.example.crypto.feature_coin.data.CoinPaprikaApi
import com.example.crypto.feature_coin.data.exceptions.CustomException
import com.example.crypto.feature_coin.data.mappers.CoinMapper.toCoin
import com.example.crypto.feature_coin.data.mappers.CoinMapper.toCoinDetail
import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.domain.model.CoinDetail
import com.example.crypto.feature_coin.domain.repositories.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi ): CoinRepository {


    override suspend fun getCoins(): List<Coin> {
        return try{
             api.getCoins().map { it.toCoin() }
        }catch (e:HttpException){
            throw CustomException.UnexpectedErrorException(e.localizedMessage ?: "Unexpected error occurred.")
        }catch (e:IOException){
            throw CustomException.NoInternetException("Couldn't reach server. Check your internet connection")
        }
    }


    override suspend fun getCoinById(coinId: String): CoinDetail {
        return try{
            api.getCoinById(coinId).toCoinDetail()
        }catch (e:HttpException){
            throw CustomException.UnexpectedErrorException(e.localizedMessage ?: "Coin Id doesn't exist")
        }catch (e:IOException){
            throw CustomException.NoInternetException("Couldn't reach server. Check your internet connection")
        }
    }

}