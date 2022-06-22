package com.example.crypto

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crypto.common.CoinConstants
import com.example.crypto.feature_coin.presentation.ui.Screen
import com.example.crypto.feature_coin.presentation.ui.coin_detail.components.CoinDetailScreen
import com.example.crypto.feature_coin.presentation.ui.coin_list.components.CoinListScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route) {

        composable(route = Screen.CoinListScreen.route){
            CoinListScreen(navController = navController)
        }

        composable(route = Screen.CoinDetailScreen.route + "/{${CoinConstants.COIN_ID}}"){
            CoinDetailScreen()
        }
    }
}