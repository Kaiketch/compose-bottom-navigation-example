package com.redpond.profile

import androidx.compose.runtime.Composable
import com.redpond.common.component.ItemList
import com.redpond.repository.UserRepositoryImpl

@Composable
fun ProfileScreen() {
    val user = UserRepositoryImpl()
    ItemList(text = user.fetchUser(1).name)
}
