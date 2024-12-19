package org.hyperskill.example

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

private const val BASE_NAME_SPACE = "org.hyperskill.example"

internal fun Project.configureKotlinAndroid(
    extension: LibraryExtension
) = extension.apply {
    //get module name from module path
    val moduleName: String = path.filter { it != ':' }
    namespace = if(moduleName.isNotEmpty()) "$BASE_NAME_SPACE.$moduleName" else BASE_NAME_SPACE

    compileSdk = appVersions.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = appVersions.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
