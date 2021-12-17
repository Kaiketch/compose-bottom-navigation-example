package com.redpond.main

import androidx.compose.runtime.Composable
import com.redpond.repository.UserRepositoryImpl

@Composable
fun ScreenA() {
    val user = UserRepositoryImpl()
    ItemList(text = user.fetchUser(1).name)
}
