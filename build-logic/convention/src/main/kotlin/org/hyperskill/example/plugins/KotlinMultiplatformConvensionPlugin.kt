package org.hyperskill.example.plugins

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.hyperskill.example.alias
import org.hyperskill.example.configureKotlinAndroid
import org.hyperskill.example.configureKotlinMultiplatform
import org.hyperskill.example.libs
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                alias(libs.plugins.kotlinMultiplatform)
                alias(libs.plugins.androidLibrary)
                alias(libs.plugins.kotlinxSerialization)
                apply("kotlin-parcelize")
            }

            extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
            extensions.configure<LibraryExtension>(::configureKotlinAndroid)
        }
    }
}