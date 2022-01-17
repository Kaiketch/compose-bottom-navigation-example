package com.redpond

object Versions {
    const val compose = "1.2.0-alpha01"
}

object Dep {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.4"
    const val material = "com.google.android.material:material:1.5.0"
    const val junit = "junit:junit:4.+"

    object Kotlin {
        private const val version = "1.6.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.8.0-alpha01"
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha05"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha02"

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val materialIconsCore =
                "androidx.compose.material:material-icons-core:${Versions.compose}"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:${Versions.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        }
    }

    object Dagger {
        private const val version = "2.40.5"
        const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Apollo {
        private const val version = "3.0.0"
        const val gradlePlugin = "com.apollographql.apollo3:apollo-gradle-plugin:$version"
        const val runtime = "com.apollographql.apollo3:apollo-runtime:$version"
    }
}
