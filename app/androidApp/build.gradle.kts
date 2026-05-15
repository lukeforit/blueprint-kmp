plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.metro)
}

android {
    namespace = "me.lukeforit.blueprint.kmp"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "me.lukeforit.blueprint.kmp"
        minSdk =  libs.versions.android.minSdk.get().toInt()
        targetSdk =  libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.app.composeApp)
    implementation(projects.shared.common)
    implementation(projects.feature.auth)
    implementation(projects.feature.dashboard)
    implementation(projects.feature.profile)
    implementation(projects.feature.details)

    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    
    // Dependency Injection
    implementation(libs.metrox.android)
    implementation(libs.metrox.viewmodel)
}
