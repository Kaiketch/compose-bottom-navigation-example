package com.redpond

object Versions {
    const val compose = "1.2.0"
}

object Dep {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.1"
    const val material = "com.google.android.material:material:1.6.0-rc01"
    const val junit = "junit:junit:4.+"
    const val mockk = "io.mockk:mockk:1.12.3"
    const val truth = "com.google.truth:truth:1.1.3"
    const val robolectric = "org.robolectric:robolectric:4.7.3"

    object Kotlin {
        private const val version = "1.7.0"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.8.0-alpha07"
        const val appcompat = "androidx.appcompat:appcompat:1.6.0-alpha01"
        const val activityCompose = "androidx.activity:activity-compose:1.6.0-alpha05"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.5.0"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-rc02"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val dataStorePreferences = "androidx.datastore:datastore-preferences:1.0.0"

        object Compose {
            const val ui = "androidx.compose.ui:ui:1.2.0-rc02"
            const val material = "androidx.compose.material:material:1.2.0-rc02"
            const val materialIconsCore =
                "androidx.compose.material:material-icons-core:1.2.0-rc02"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:1.2.0-rc02"
            const val uiTooling = "androidx.compose.ui:ui-tooling:1.2.0-rc02"
        }
    }

    object Dagger {
        private const val version = "2.42"
        const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Apollo {
        private const val version = "3.2.2"
        const val gradlePlugin = "com.apollographql.apollo3:apollo-gradle-plugin:$version"
        const val runtime = "com.apollographql.apollo3:apollo-runtime:$version"
    }

    object Accompanist {
        private const val version = "0.24.6-alpha"
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:$version"
    }
}
