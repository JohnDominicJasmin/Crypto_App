package com.example.crypto.di

import com.example.crypto.core.CoinConstants
import com.example.crypto.feature_coin.data.CoinPaprikaApi
import com.example.crypto.feature_coin.data.repository.CoinRepositoryImpl
import com.example.crypto.feature_coin.domain.repositories.CoinRepository
import com.example.crypto.feature_coin.domain.use_case.CoinUseCase
import com.example.crypto.feature_coin.domain.use_case.get_coin.GetCoinByIdUseCase
import com.example.crypto.feature_coin.domain.use_case.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinModule {


    @Provides
    @Singleton
    fun providesCoinPaprikaApi():CoinPaprikaApi =
        Retrofit.Builder()
            .baseUrl(CoinConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)



    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideCoinUseCase(repository: CoinRepository):CoinUseCase = CoinUseCase(
        getCoinsUseCase =  GetCoinsUseCase(repository),
        getCoinByIdUseCase = GetCoinByIdUseCase(repository)
    )
}