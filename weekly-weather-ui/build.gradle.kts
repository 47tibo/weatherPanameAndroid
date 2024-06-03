plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.jmailenKotlinter)
    alias(libs.plugins.jetbrainsKotlinxKover)
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
}

kotlin {
    explicitApi()
}

dependencies {
    implementation(project(":weather"))
    implementation(project(":android-platform"))

    implementation(libs.dagger.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.dagger.hilt.android.compiler)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    implementation("androidx.navigation:navigation-compose:2.7.7")

    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("io.coil-kt:coil-svg:2.6.0")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0-RC.2")

    testImplementation(libs.junit)
}
