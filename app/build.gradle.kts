plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.tibo47.weatherPaname"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tibo47.weatherPaname"
        minSdk = 28
        targetSdk = 33 // targets bitrise virtual device
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.tibo47.weatherPaname.ApplicationTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            resValue("string", "clear_text_config","false")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            resValue("string", "clear_text_config","true")
        }
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,LICENSE.md,LICENSE-notice.md}"
        }
        jniLibs {
            useLegacyPackaging = true
        }
    }
}

dependencies {
    implementation(project(":android-platform"))
    implementation(project(":weekly-weather-ui"))
    androidTestImplementation(project(":weather")) // for WeatherApi testing

    implementation(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    androidTestImplementation(libs.hilt.android.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core) // for AndroidJUnitRunner
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    androidTestImplementation(libs.mockk)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.mockk.agent)

    androidTestImplementation(libs.kotlinx.datetime) // for Clock

    androidTestImplementation(libs.retrofit) // for types
    androidTestImplementation(libs.okhttp.mockwebserver)
}
