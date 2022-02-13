package com.example.crypto.feature_coin.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crypto.common.CoinConstants
import com.example.crypto.feature_coin.presentation.ui.coin_detail.components.CoinDetailScreen
import com.example.crypto.feature_coin.presentation.ui.coin_list.components.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val navController  = rememberNavController()
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
            }
        }
    }
}


