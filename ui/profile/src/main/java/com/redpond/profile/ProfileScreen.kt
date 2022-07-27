package com.redpond.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redpond.base.component.AppTextField
import com.redpond.base.viewmodel.UserViewModel

@Composable
fun ProfileScreen(
    userViewModel: UserViewModel,
    navigateToCountry: (countryCode: String) -> Unit
) {
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

            Spacer(modifier = Modifier.height(8.dp))

            userUiState.user.countryCode?.let { code ->
                Text(text = code)

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { navigateToCountry(code) }
                ) {
                    Text(text = "Open")
                }
            }
        }
        if (userUiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
