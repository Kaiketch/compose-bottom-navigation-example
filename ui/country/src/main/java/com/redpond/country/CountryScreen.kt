package com.redpond.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redpond.base.viewmodel.UserViewModel

@Composable
fun CountryScreen(
    userViewModel: UserViewModel,
    countryViewModel: CountryViewModel,
    popBackStack: () -> Unit
) {
    val countryUiState by countryViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = countryUiState.country?.name.orEmpty(),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            Text(text = "code")
            Text(text = countryUiState.country?.code.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "name")
            Text(text = countryUiState.country?.name.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "capital")
            Text(text = countryUiState.country?.capital.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "currency")
            Text(text = countryUiState.country?.currency.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    userViewModel.onUpdateCountryClicked(countryUiState.country?.code)
                    popBackStack()
                }
            ) {
                Text(text = "Update")
            }
        }
        if (countryUiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
