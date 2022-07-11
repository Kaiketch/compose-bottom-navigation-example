package com.redpond.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.redpond.base.Args.Companion.CODE
import com.redpond.base.LocalNavController
import com.redpond.base.Screen
import com.redpond.base.bottomNavItems
import com.redpond.profile.ProfileScreen
import com.redpond.search.SearchScreen

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun MainContent() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isNavigationScreen = bottomNavItems.map { it.route }.contains(currentDestination?.route)

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        Scaffold(
            bottomBar = {
                if (isNavigationScreen) {
                    AppBottomNavigation(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        ) { paddingValues ->
            AppNavHost(navController = navController, paddingValues = paddingValues)
        }
    }
}

@Composable
fun AppBottomNavigation(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    BottomNavigation {
        bottomNavItems.forEach { screen ->
            val icon = screen.icon
            BottomNavigationItem(
                icon = { icon?.let { Icon(icon, null) } },
                label = { screen.resourceId?.let { Text(stringResource(it)) } },
                selected = currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Search.route,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(Screen.Search.route) { SearchScreen() }
        composable(
            "${Screen.Detail.route}/{$CODE}",
            arguments = listOf(navArgument(CODE) { type = NavType.StringType }),
        ) {
            com.redpond.country.CountryScreen()
        }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}
