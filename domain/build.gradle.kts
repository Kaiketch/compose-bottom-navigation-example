import com.redpond.BuildConfig
import com.redpond.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = BuildConfig.compileSdk
}

dependencies {
    implementation(Dep.Kotlin.Coroutines.core)

    testImplementation(Dep.junit)
}
