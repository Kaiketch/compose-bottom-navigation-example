package com.redpond.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redpond.base.LocalNavController
import com.redpond.base.Screen

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val navController = LocalNavController.current
    val uiState by searchViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.screen_search),
                    )
                }
            )
        }
    ) {
        LazyColumn {
            items(uiState.countries) {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .clickable { navController.navigate("${Screen.Detail.route}/${it.code}") }
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Divider()
            }
        }
    }
}
