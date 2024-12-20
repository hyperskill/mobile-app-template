import org.jetbrains.kotlin.konan.properties.loadProperties
import org.jetbrains.kotlin.konan.properties.propertyString

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

    val properties = loadProperties("${project.rootDir}/config/production.properties")

    properties.keys.forEach { name ->
        name as String
        val propertyValue = properties.propertyString(name)
        buildConfigField(
            name = name,
            value = requireNotNull(propertyValue) {
                "Property $name is not set"
            }
        )
    }
}