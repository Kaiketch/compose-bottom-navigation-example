package com.redpond

object Versions {
    const val compose = "1.0.5"
}

object Dep {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"
    const val material = "com.google.android.material:material:1.4.0"
    const val junit = "junit:junit:4.+"

    object Kotlin {
        private const val version = "1.5.31"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-beta02"

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
}
