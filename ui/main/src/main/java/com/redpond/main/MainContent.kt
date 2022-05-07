package com.redpond.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.redpond.base.Args.Companion.CODE
import com.redpond.base.LocalNavController
import com.redpond.base.Screen
import com.redpond.base.bottomNavItems
import com.redpond.favorite.FavoriteScreen
import com.redpond.profile.ProfileScreen
import com.redpond.search.SearchScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent() {
    val navController = rememberAnimatedNavController()
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
                label = { Text(stringResource(screen.resourceId)) },
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Search.route,
        modifier = Modifier.padding(paddingValues),
        enterTransition = {
            // BottomNav画面同士の遷移ではEnterアニメーションは切る
            if (bottomNavItems.map { it.route }.contains(initialState.destination.route) &&
                bottomNavItems.map { it.route }.contains(targetState.destination.route)
            ) {
                fadeIn(animationSpec = snap())
            } else {
                fadeIn(animationSpec = tween(500))
            }
        },
        exitTransition = {
            // BottomNav画面との遷移ではチラつき対策も含め遷移元のExitアニメーションを切る
            if (bottomNavItems.map { it.route }.contains(initialState.destination.route) ||
                bottomNavItems.map { it.route }.contains(targetState.destination.route)
            ) {
                fadeOut(animationSpec = snap())
            } else {
                fadeOut(animationSpec = tween(500))
            }
        },
    ) {
        composable(Screen.Search.route) { SearchScreen() }
        composable(
            "${Screen.Detail.route}/{$CODE}",
            arguments = listOf(navArgument(CODE) { type = NavType.StringType }),
        ) {
            com.redpond.country.CountryScreen()
        }

        composable(Screen.Favorite.route) { FavoriteScreen() }

        composable(Screen.Profile.route) { ProfileScreen() }
    }
}
