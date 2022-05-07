package com.redpond.base

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController

val LocalNavController = staticCompositionLocalOf<NavController> {
    error("NavController not found")
}

val LocalActivity = staticCompositionLocalOf<AppCompatActivity> {
    error("Activity not found")
}
