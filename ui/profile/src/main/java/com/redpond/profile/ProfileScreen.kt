package com.redpond.profile

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redpond.base.LocalActivity
import com.redpond.base.viewmodel.UserViewModel

@Composable
fun ProfileScreen(
    userViewModel: UserViewModel = viewModel(LocalActivity.current)
) {
    val userUiState by userViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.title, userUiState.user.name),
                    )
                }
            )
        }
    ) {
        Text(
            text = userUiState.user.name,
        )
    }
}
