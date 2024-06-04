plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.kover)
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
