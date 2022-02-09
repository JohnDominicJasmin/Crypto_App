package com.example.crypto.feature_coin.presentation.ui.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Status(args:Boolean, modifier: Modifier) {
    Text(
        text = if(args)"Active" else "Inactive",
        color = if(args) Color.Green else Color.Gray,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.body2,
        modifier = modifier
        )
}