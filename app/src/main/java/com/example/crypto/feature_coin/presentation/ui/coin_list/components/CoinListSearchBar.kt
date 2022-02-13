package com.example.crypto.feature_coin.presentation.ui.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CoinListSearchBar(
    searchQuery: String,
    onValueChange: (String) -> Unit) {

    val keyboardController = LocalSoftwareKeyboardController.current
        Surface(
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight().padding(all = 17.dp),
            color = Color.White,
            shape = RoundedCornerShape(20)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    value = searchQuery,
                    onValueChange = onValueChange,
                    label = { Text(text = "Search") },
                    modifier = Modifier.fillMaxWidth(0.96f),
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    leadingIcon = {
                        Icon(contentDescription = "SearchIcon", imageVector = Icons.Default.Search)
                    },
                    singleLine = true,
                    keyboardActions = KeyboardActions(onSearch = {
                        keyboardController?.hide()
                    }),
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                ))
            }

        }
}

@Preview
@Composable
fun SearchBar() {
    var searchQuery by remember{(mutableStateOf(""))}
    CoinListSearchBar(searchQuery = searchQuery){
        searchQuery = it
    }
}