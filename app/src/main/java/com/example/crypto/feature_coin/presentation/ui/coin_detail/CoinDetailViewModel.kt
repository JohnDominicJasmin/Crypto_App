package com.example.crypto.feature_coin.presentation.ui.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.CoinConstants
import com.example.crypto.common.Resource
import com.example.crypto.feature_coin.domain.use_case.CoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinUseCase: CoinUseCase,
    savedStateHandle: SavedStateHandle ):ViewModel() {

    private val _coinListState = mutableStateOf(CoinDetailState())
    val coinListState:State<CoinDetailState> = _coinListState


    init{
        savedStateHandle.get<String>(CoinConstants.COIN_ID)?.let {
            getCoin(it)
        }
    }

    
    private fun getCoin(coinId:String) {

        coinUseCase.getCoinByIdUseCase(coinId).onEach { result ->

                when (result) {
                    is Resource.Success -> {
                        _coinListState.value = CoinDetailState(coins = result.data)
                    }
                    is Resource.Error ->{
                        _coinListState.value = CoinDetailState(isLoading = false, error = result.message?:"An unexpected error occurred.")
                    }
                    is Resource.Loading ->{
                        _coinListState.value = CoinDetailState(isLoading = true)
                    }

                }
        }.launchIn(viewModelScope)
    }
}