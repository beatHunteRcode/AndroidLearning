plugins {
    with(libs) {
        alias(plugins.android.application)
        alias(plugins.jetbrains.kotlin.android)
        alias(plugins.kotlin.kapt)
        alias(plugins.compose.compiler)

        //Scabbard (Dagger2 Graph visualizer)
        alias(plugins.scabbard)

        alias(plugins.kotlin.serialization)

        alias(plugins.androidx.navigation.safeargs.kotlin)
    }
}

allprojects {
    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "com.github.kittinunf.result" && requested.name == "result" && requested.version == "3.0.0") {
                useVersion("3.0.1")
                because("Transitive dependency of Scabbard, currently not available on mavenCentral()")
            }
        }
    }
}

android {
    namespace = "com.example.androidlearning"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.androidlearning"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    // Doesn't work due to addition classpath(libs.androidx.navigation.safeargs.gradleplugin) (wtf???)
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(libs.androidx.navigation.safeargs.gradleplugin)
    }
}

scabbard {
    enabled = true
    outputFormat = "svg"
}

dependencies {
    implementation(libs.android.ktx)
    implementation(platform(libs.compose.bom))
    implementation(platform(libs.kotlin.bom))
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.material)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.fragment.compose)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)

    //dagger
    kapt(libs.dagger.compiler)
    implementation(libs.dagger)
    implementation(libs.dagger.android.support)
    annotationProcessor(libs.dagger.compiler)

    //Kaspresso (UI testing)
    androidTestImplementation(libs.kaspresso)
    // Allure support
    androidTestImplementation(libs.kaspresso.allure.support)
    // Jetpack Compose support
    androidTestImplementation(libs.kaspresso.compose.support)

    //json serialization
    implementation(libs.kotlinx.serialization.json)
}