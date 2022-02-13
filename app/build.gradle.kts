import com.redpond.BuildConfig
import com.redpond.Dep
import com.redpond.Versions

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildConfig.compileSdk

    defaultConfig {
        applicationId = "com.redpond.composebuttomnavigationexample"
        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.targetSdk
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data:repository"))
    implementation(project(":data:api"))
    implementation(project(":ui:main"))
    implementation(project(":ui:common"))
    implementation(project(":ui:profile"))
    implementation(project(":ui:search"))
    implementation(project(":ui:favorite"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.material)
    implementation(Dep.AndroidX.hiltNavigationCompose)

    testImplementation(Dep.junit)

    implementation(Dep.AndroidX.activityCompose)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.materialIconsCore)
    implementation(Dep.AndroidX.Compose.materialIconsExtended)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)
}
