plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") version "2.0.21-1.0.28"
    id("com.google.dagger.hilt.android") version "2.50"
}

android {
    namespace = "com.fabianospdev.petscare"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.fabianospdev.petscare"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    ksp {
        arg("room.incremental", "true")
    }

    testOptions.unitTests.isIncludeAndroidResources = true
    buildFeatures {
        compose = true
        viewBinding = true
    }
    buildToolsVersion = "34.0.0"
}

configurations.all {
    resolutionStrategy {
//        force("androidx.core:core:1.15.0")
//        force("androidx.navigation:navigation-common:2.5.1")
    }
}


dependencies {
    // Core Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.runtime.livedata)

    // Hilt
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    ksp(libs.hilt.viewmodel.compiler)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.common)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    // Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    // Testing dependencies
    implementation(libs.androidx.junit)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.ui.test.junit4.android)
    implementation(libs.androidx.ui.text.google.fonts)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.junit)
    testImplementation(libs.roboeletric)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.mokito.kotlin)
    androidTestImplementation(libs.navigation.testing)

    // Debug dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}