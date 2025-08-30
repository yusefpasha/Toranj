import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(17)
}

android {

    namespace = "com.dadehfa.toranj"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.dadehfa.toranj"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            keyAlias = getLocalPropertyOrSystemEnvironment("SIGNING_KEY_ALIAS")
            storeFile = file(getLocalPropertyOrSystemEnvironment("SIGNING_STORE_FILE"))
            keyPassword = getLocalPropertyOrSystemEnvironment("SIGNING_KEY_PASSWORD")
            storePassword = getLocalPropertyOrSystemEnvironment("SIGNING_STORE_PASSWORD")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    buildFeatures {
        compose = true
    }
}

composeCompiler {
    includeSourceInformation = true
}

dependencies {
    implementation(project(":common:ui"))
    implementation(project(":features:splash"))
    implementation(project(":features:register"))
    implementation(project(":features:operations"))
    implementation(project(":features:dashboard"))
    implementation(project(":features:setting"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.bundles.koin.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

fun Project.getLocalPropertyOrSystemEnvironment(key: String): String {
    val localProperties = Properties()
    val localPropertiesFile = rootProject.file("local.properties")
    val result = if (localPropertiesFile.exists()) {
        val props = localProperties.apply {
            load(localPropertiesFile.inputStream())
        }
        props.getProperty(key) ?: error("$key not found in local.properties")
    } else {
        System.getenv(key) ?: error("$key not found in environment variables")
    }
    return result
}