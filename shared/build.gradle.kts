import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.example.multiplatform)
    alias(libs.plugins.kotlinCocoapods)
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
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
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