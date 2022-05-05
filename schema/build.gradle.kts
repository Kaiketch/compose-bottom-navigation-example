import com.redpond.BuildConfig
import com.redpond.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.apollographql.apollo3")
}

android {
    compileSdk = BuildConfig.compileSdk
}

apollo {
    packageName.set("com.redpond")
}

dependencies {
    testImplementation(Dep.junit)
    api(Dep.Apollo.runtime)
}
