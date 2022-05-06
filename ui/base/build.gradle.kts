import com.redpond.BuildConfig
import com.redpond.Dep
import com.redpond.Versions

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = BuildConfig.compileSdk
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(":domain"))

    testImplementation(Dep.junit)
    implementation(Dep.AndroidX.core)

    implementation(Dep.AndroidX.navigationCompose)
    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.materialIconsCore)
    implementation(Dep.AndroidX.Compose.materialIconsExtended)
    implementation(Dep.AndroidX.Compose.uiTooling)
}
