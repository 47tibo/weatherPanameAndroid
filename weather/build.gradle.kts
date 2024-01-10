plugins {
    id("org.jetbrains.kotlin.jvm")
}

kotlin {
    explicitApi()
}

dependencies {
    implementation("javax.inject:javax.inject:1")
}
