package com.redpond.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redpond.base.LocalNavController

@Composable
fun CountryScreen(
    countryViewModel: CountryViewModel = hiltViewModel()
) {
    val navController = LocalNavController.current
    val uiState by countryViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = uiState.country?.name.orEmpty(),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
            Text(text = "name")
            Text(text = uiState.country?.name.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "capital",)
            Text(text = uiState.country?.capital.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "currency",)
            Text(text = uiState.country?.currency.orEmpty())

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { }) {
                Text(text = "Submit")
            }
        }
    }
}
