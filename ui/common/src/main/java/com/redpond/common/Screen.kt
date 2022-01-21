package com.redpond.common

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector? = null
) {
    object Search : Screen("screen_search", R.string.screen_search, Icons.Filled.Search)
    object Favorite : Screen("screen_favorite", R.string.screen_favorite, Icons.Filled.Favorite)
    object Profile : Screen("screen_account", R.string.screen_profile, Icons.Filled.Person)
    object Detail : Screen("screen_detail", R.string.screen_detail)
}

val bottomNavItems = listOf(
    Screen.Search,
    Screen.Favorite,
    Screen.Profile,
)
