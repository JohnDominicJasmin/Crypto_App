package com.example.crypto.feature_coin.presentation.ui.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.crypto.feature_coin.presentation.ui.coin_detail.CoinDetailViewModel
import com.example.crypto.feature_coin.presentation.ui.common.Status

@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    with(viewModel.coinListState.value) {
        Box(modifier = Modifier.fillMaxSize()) {

            coins?.let { coin->

                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)) {

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
               
                             Text(
                                 text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                                 style = MaterialTheme.typography.h2,
                                 modifier = Modifier.weight(8f)
                             )


                            Status(
                                args = coin.isActive,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )


                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = coin.description,
                            style = MaterialTheme.typography.body2
                            )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Tags",
                            style = MaterialTheme.typography.h3
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth()) {

                            coin.tags.forEach { tag-> CoinTag(tags = tag) }

                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Team members",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    items(coin.team){ member ->
                        TeamListItem(teamMember = member , modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp))
                        Divider()
                    }


                }

            }



            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }


    }
}