plugins {
    alias(libs.plugins.example.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":base"))
                implementation(project(":redux"))
                implementation(libs.kermit)
                implementation(libs.sentry.common)
            }
        }
    }
}