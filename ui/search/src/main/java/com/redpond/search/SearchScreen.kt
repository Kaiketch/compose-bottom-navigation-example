package com.redpond.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redpond.base.viewmodel.UserViewModel

@Composable
fun SearchScreen(
    userViewModel: UserViewModel,
    searchViewModel: SearchViewModel,
    navigateToCountry: (countryCode: String) -> Unit
) {
    val userUiState by userViewModel.uiState.collectAsState()
    val searchUiState by searchViewModel.uiState.collectAsState()

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
        LazyColumn(modifier = Modifier.padding(it)) {
            items(searchUiState.countries) { item ->
                Text(
                    text = "【${item.code}】${item.name}",
                    modifier = Modifier
                        .clickable {
                            navigateToCountry(item.code)
                        }
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Divider()
            }
        }
        if (userUiState.isLoading || searchUiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
