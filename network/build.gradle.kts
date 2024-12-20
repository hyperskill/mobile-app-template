plugins {
    alias(libs.plugins.example.multiplatform)
    alias(libs.plugins.buildConfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":base"))
            api(libs.bundles.ktor.common)
        }
        androidMain.dependencies {
            implementation(libs.ktor.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.ios)
        }
    }
}

buildConfig {
    packageName = "org.hyperskill.example.netwrork"
    className = "NetworkBuildConfig"

    useKotlinOutput {
        internalVisibility = true
    }

    addBuildConfigFieldsByPrefix(
        project = project,
        pathToPropertiesFile = "${project.rootDir}/config/production.properties",
        prefix = "NETWORK"
    )
}