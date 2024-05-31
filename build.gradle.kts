plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false

    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.jetbrainsKotlinPluginSerialization) apply false

    alias(libs.plugins.devtoolsKsp) apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false

    id("org.jmailen.kotlinter") version "4.1.1" apply false
    id("org.jetbrains.kotlinx.kover") version "0.7.5" apply false

    id("org.openapi.generator") version "7.2.0" apply false
}
