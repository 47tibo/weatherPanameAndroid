plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jmailenKotlinter)
    alias(libs.plugins.jetbrainsKotlinxKover)
}

android {
    namespace = "com.tibo47.androidPlatform"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
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

    kotlin {
        jvmToolchain(17)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {
    implementation(libs.androidx.activity.compose) // for WindowCompat.getInsetsController
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
}
