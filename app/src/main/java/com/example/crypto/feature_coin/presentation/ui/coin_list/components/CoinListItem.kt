package com.example.crypto.feature_coin.presentation.ui.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crypto.feature_coin.domain.model.Coin
import com.example.crypto.feature_coin.presentation.ui.common.Status

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(coin) }
        .padding(15.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

        with(coin) {
            Text(
                text = "$rank. $name ($symbol)",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
            )

            Status(
                args = is_active,
                modifier = Modifier.align(CenterVertically)
            )


        }
    }

}


@Composable
@Preview
fun CoinItemPreview() {
    MaterialTheme {

    }
}