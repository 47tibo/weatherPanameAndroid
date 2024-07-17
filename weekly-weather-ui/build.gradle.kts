plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.kover)
    alias(libs.plugins.screenshot)
}

android {
    namespace = "com.tibo47.weatherPaname.weeklyWeatherUi"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

kotlin {
    explicitApi()
}

dependencies {
    implementation(project(":weather"))
    implementation(project(":android-platform"))

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.lifecycle.runtime.compose)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.coil.compose)
    implementation(libs.coil.svg)

    implementation(libs.kotlinx.datetime)

    testImplementation(libs.junit)

    screenshotTestImplementation(libs.androidx.compose.ui.tooling)
}
