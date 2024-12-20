import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.example.multiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.buildConfig)
}

kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = appVersions.versions.iosDeploymentTarget.get()
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = false
            binaryOption("bundleId", "org.hyperskill.example.shared")
            // Add export declarations to use base module from Swift side
            export(project(":base"))
        }
        pod("Sentry") {
            version = libs.versions.sentry.cocoapods.get()
            linkOnly = true
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            api(project(":base"))
            implementation(project(":logging"))
            implementation(project(":network"))
            implementation(libs.sentry.common)
            //put your multiplatform dependencies here
        }
    }

    // https://kotlinlang.org/docs/multiplatform-expect-actual.html#expected-and-actual-classes
    // To suppress this warning about usage of expected and actual classes
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

buildConfig {
    packageName = "org.hyperskill.example.config"
    className = "SharedBuildConfig"

    useKotlinOutput {
        internalVisibility = true
    }

    addBuildConfigFieldsByPrefix(
        project = project,
        pathToPropertiesFile = "${project.rootDir}/config/production.properties",
        prefix = "SHARED"
    )
}