package com.redpond.base.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemList(text: String) {
    LazyColumn {
        repeat(30) {
            item {
                Text(text = "$text$it", modifier = Modifier.padding(16.dp))
                Divider()
            }
        }
    }
}
