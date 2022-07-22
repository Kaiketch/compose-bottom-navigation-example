package com.redpond.base

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Graph(
    val route: String
) {
    object Search : Graph("graph_search")
    object Profile : Graph("graph_profile")
}

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int? = null,
    val icon: ImageVector? = null
) {
    object Search : Screen("screen_search", R.string.tab_search, Icons.Filled.Search)
    object Profile : Screen("screen_account", R.string.tab_profile, Icons.Filled.Person)
    object Detail : Screen("screen_detail")
}

val bottomNavItems = listOf(
    Screen.Search,
    Screen.Profile,
)
