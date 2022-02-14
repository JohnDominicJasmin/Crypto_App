package com.example.crypto.feature_coin.presentation.ui.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.crypto.common.CoinConstants
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
        .padding(top = 10.dp, bottom = 10.dp, start = 12.dp, end = 15.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

        with(coin) {

            Row(verticalAlignment = CenterVertically){
                Image(
                    painter = rememberImagePainter("${CoinConstants.CRYPTO_ICON_BASE_URL}${symbol.lowercase()}"),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = ParagraphStyle(lineHeight = 22.sp)) {
                            withStyle(style = SpanStyle(color = Color.White)) {
                                append("$name\n")
                            }
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append(symbol)
                            }
                        }
                    },
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                )
            }





            Status(args = is_active, modifier = Modifier.align(CenterVertically))


        }

    }
    Divider()

}
