plugins {
    `kotlin-dsl`
}

group = "com.dadehfa.toranj.gradleSrc"

kotlin {
    jvmToolchain(17)
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

tasks {
    validatePlugins {
        failOnWarning = true
        enableStricterValidation = true
    }
}
