package com.example.crypto.feature_coin.presentation.ui.coin_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.crypto.feature_coin.presentation.ui.Screen
import com.example.crypto.feature_coin.presentation.ui.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val searchQuery = remember { (mutableStateOf(TextFieldValue(text = ""))) }
    var isCoinFound by remember { mutableStateOf(false) }

    CoinListSearchBar(searchQuery = searchQuery)
    with(viewModel.coinListState.value) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.5.dp)
        ) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {




                items(coins.take(n = 100).filter {

                    isCoinFound = it.name.contains(
                        searchQuery.value.text,
                        ignoreCase = true) || it.symbol.contains(searchQuery.value.text, ignoreCase = true)

                    return@filter isCoinFound }) { coin ->

                        CoinListItem(coin = coin, onItemClick = { clickedCoin ->
                            navController.navigate(route = Screen.CoinDetailScreen.route + "/${clickedCoin.id}")
                        })
                }

                


            }

            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp)
                        .align(Alignment.Center)
                )
            }

            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }


}