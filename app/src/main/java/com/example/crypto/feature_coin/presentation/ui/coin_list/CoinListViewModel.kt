package com.example.crypto.feature_coin.presentation.ui.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.core.Resource
import com.example.crypto.feature_coin.domain.use_case.CoinUseCase
import com.example.crypto.feature_coin.presentation.ui.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinUseCase: CoinUseCase):ViewModel() {

    private val _coinListState = mutableStateOf(CoinListState())
    val coinListState:State<CoinListState> = _coinListState


    init{
        getCoin()
    }


    private fun getCoin() {
        coinUseCase.getCoinsUseCase().onEach { result ->

                when (result) {
                    is Resource.Success -> {
                        _coinListState.value = CoinListState(coins = result.data?: emptyList())
                    }
                    is Resource.Error ->{
                        _coinListState.value = CoinListState(isLoading = false, error = result.message?:"An unexpected error occurred.")
                    }
                    is Resource.Loading ->{
                        _coinListState.value = CoinListState(isLoading = true)
                    }

                }
        }.launchIn(viewModelScope)
    }
}