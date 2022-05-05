import com.redpond.BuildConfig
import com.redpond.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildConfig.compileSdk
}

dependencies {
    implementation(project(":domain"))

    testImplementation(Dep.junit)
    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.hiltNavigationCompose)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)
}
