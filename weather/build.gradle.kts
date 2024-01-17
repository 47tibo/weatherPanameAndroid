plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("org.openapi.generator")
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
}

dependencies {
    implementation("javax.inject:javax.inject:1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
}
