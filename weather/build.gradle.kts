import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("org.openapi.generator")
    id("org.jmailen.kotlinter")
    id("org.jetbrains.kotlinx.kover")
}

val fileTree = fileTree("src/main")
fileTree.include("**/*Dto.kt")
fileTree.include("**/WeatherApi.kt")

tasks.withType<LintTask> {
    this.source = this.source.minus(fileTree).asFileTree
}

tasks.withType<FormatTask> {
    this.source = this.source.minus(fileTree).asFileTree
}

android {
    namespace = "com.tibo47.weatherPaname.weather"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://api.openweathermap.org/\"")
        buildConfigField("String", "OPEN_WEATHER_APP_ID", "\"345e941e9f02f909c7f3a37e078a3904\"")

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
}

kotlin {
    explicitApi()
}

openApiGenerate {
    generatorName = "kotlin"
    outputDir = "$projectDir"
    templateDir = "$projectDir/open_weather_api/template"
    inputSpecRootDirectory = "$projectDir/open_weather_api"
    modelPackage = "com.tibo47.weatherPaname.weather.dataprovider.remote.dto"
    apiPackage = "com.tibo47.weatherPaname.weather.dataprovider.remote.api"
    modelNameSuffix = "Dto"
    // for details :  https://openapi-generator.tech/docs/globals/#available-global-properties
    globalProperties = mapOf(
        "apis" to "",
        "models" to "",
        "modelDocs" to "false",
        "apiDocs" to "false",
    )
    additionalProperties = mapOf(
        "sourceFolder" to "src/main/java",
        "useCoroutines" to "true",
        "library" to "jvm-retrofit2",
        "serializationLibrary" to "kotlinx_serialization",
    )
    typeMappings = mapOf(
        "number" to "kotlin.Float",
    )
}

dependencies {
    implementation(project(":http-client"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    implementation("com.google.dagger:hilt-android:2.48.1")
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0-RC.2")

    // for generated DTOs
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
}
