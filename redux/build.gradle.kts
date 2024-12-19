plugins {
    alias(libs.plugins.example.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kit.presentation.redux)
                implementation(libs.kit.presentation.reduxCoroutines)
                implementation(libs.androidx.lifecycle.viewmodel)
            }
        }
    }
}