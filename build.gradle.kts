plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false

    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.jetbrainsKotlinPluginSerialization) apply false

    alias(libs.plugins.devtoolsKsp) apply false
    alias(libs.plugins.daggerHiltAndroid) apply false

    alias(libs.plugins.jmailenKotlinter) apply false
    alias(libs.plugins.jetbrainsKotlinxKover) apply false

    alias(libs.plugins.openapiGenerator) apply false
}
