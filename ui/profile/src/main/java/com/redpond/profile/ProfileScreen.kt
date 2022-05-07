package com.redpond.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redpond.base.LocalActivity
import com.redpond.base.LocalNavController
import com.redpond.base.Screen
import com.redpond.base.component.AppTextField
import com.redpond.base.viewmodel.UserViewModel

@ExperimentalComposeUiApi
@Composable
fun ProfileScreen(
    userViewModel: UserViewModel = viewModel(LocalActivity.current)
) {
    val navController = LocalNavController.current
    val userUiState by userViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.title, userUiState.user.name.orEmpty()),
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

            var name by remember { mutableStateOf(userUiState.user.name.orEmpty()) }
            AppTextField(value = name, onValueChange = { value -> name = value })

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { userViewModel.onUpdateNameClicked(name) }) {
                Text(text = "Update")
            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(text = "country code")
            userUiState.user.countryCode?.let {
                Button(
                    onClick = { navController.navigate("${Screen.Detail.route}/${it}") }
                ) {
                    Text(text = it)
                }
            }
        }
    }
}
