package com.redpond.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {

            Text(text = "name")

            var name by remember { mutableStateOf(userUiState.user.name) }
            TextField(value = name, onValueChange = { value -> name = value })

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { userViewModel.onUpdateNameClicked(name) }) {
                Text(text = "Submit")
            }
        }
    }
}
