plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.jmailenKotlinter)
    alias(libs.plugins.jetbrainsKotlinxKover)
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

    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.android.compiler)
    androidTestImplementation(libs.dagger.hilt.android.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core) // for AndroidJUnitRunner
    androidTestImplementation(libs.androidx.ui.test.junit4)

    androidTestImplementation("io.mockk:mockk:1.13.10")
    androidTestImplementation("io.mockk:mockk-android:1.13.10")
    androidTestImplementation("io.mockk:mockk-agent:1.13.10")

    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0-RC.2") // for Clock

    androidTestImplementation(platform(libs.androidx.compose.bom))

    androidTestImplementation("com.squareup.retrofit2:retrofit:2.9.0") // for types
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
}
