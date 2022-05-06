package com.redpond.profile

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.screen_profile),
                    )
                }
            )
        }
    ) {
        Text(
            text = stringResource(id = R.string.screen_profile),
        )
    }
}
