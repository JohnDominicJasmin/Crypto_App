package com.example.crypto.feature_coin.presentation.ui.coin_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crypto.feature_coin.presentation.ui.coin_detail.CoinDetailViewModel
import com.example.crypto.feature_coin.presentation.ui.common.Status
import com.google.accompanist.flowlayout.FlowRow
import timber.log.Timber

@ExperimentalMaterialApi
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current

        Box(modifier = Modifier.fillMaxSize()) {
            with(viewModel.coinListState.value) {
            coins?.let { coin->

                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)) {

                    item {

                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween) {

                             Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                                 style = MaterialTheme.typography.h5,
                                 modifier = Modifier.weight(8f))


                            Status(args = coin.isActive,
                                   modifier = Modifier.align(Alignment.CenterVertically))


                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = coin.description?:"Description is not available.",
                            color = if(coin.description == null) Color.Gray else Color.White,
                            style = MaterialTheme.typography.body2)

                        Spacer(modifier = Modifier.height(12.dp))


                        coin.tags?.let { coinTag ->

                            Text(
                                text = "Tags",
                                style = MaterialTheme.typography.h5)

                            Spacer(modifier = Modifier.height(12.dp))

                            FlowRow(
                                mainAxisSpacing = 10.dp,
                                crossAxisSpacing = 10.dp,
                                modifier = Modifier.fillMaxWidth()) {
                                coinTag.forEach { tag -> CoinTag(tag) }
                            }
                        }
                    }





                    coin.team?.let { coinTeam ->

                        if (coinTeam.isNotEmpty()) {

                            item {

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(text = "Team members",
                                    style = MaterialTheme.typography.h5)

                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }

                        items(coinTeam) { member ->

                            TeamListItem(
                                teamMember = member, modifier = Modifier.clickable {
                                    openBrowser(context = context, searchItem = "${member.name} ${member.position} of ${coin.name}")
                                }
                                    .fillMaxWidth()
                                    .padding(10.dp))
                            Divider()
                        }
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
