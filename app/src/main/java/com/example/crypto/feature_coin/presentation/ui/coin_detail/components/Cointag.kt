package com.example.crypto.feature_coin.presentation.ui.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CoinTag(
    tags:String
) { 
    
    Surface(modifier = Modifier
        .border(
            width = 2.dp,
            color = Color.Green,
            shape = RoundedCornerShape(60.dp)
        ).padding(all = 13.dp)) {

        Text(
            text = tags,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2
            )
    }
    
}