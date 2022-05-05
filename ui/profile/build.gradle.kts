import com.redpond.BuildConfig
import com.redpond.Dep
import com.redpond.Versions

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
    implementation(project(":ui:common"))

    testImplementation(Dep.junit)
    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.viewModelCompose)
    implementation(Dep.AndroidX.hiltNavigationCompose)

    implementation(Dep.AndroidX.navigationCompose)
    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.materialIconsCore)
    implementation(Dep.AndroidX.Compose.materialIconsExtended)
    implementation(Dep.AndroidX.Compose.uiTooling)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)
}
