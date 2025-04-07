// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    with(libs) {
        alias(plugins.android.application) apply false
        alias(plugins.compose.compiler) apply false
        alias(plugins.kotlin.serialization) apply false
    }
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}