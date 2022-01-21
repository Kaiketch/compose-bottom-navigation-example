package com.redpond.favorite

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.screen_favorite),
                    )
                }
            )
        }
    ) {
        Text(
            text = stringResource(id = R.string.screen_favorite),
        )
    }
}
