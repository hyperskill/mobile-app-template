import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

@Suppress("MagicNumber")
internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    jvmToolchain(appVersions.versions.jvmToolchain.get().toInt())

    androidTarget {
        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)

            // In Kotlin 2.0 and higher, aliasing annotations that trigger plugins is unsupported.
            freeCompilerArgs.addAll(
                "-P",
                "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=org.hyperskill.example.parcelize.Parcelize"
            )
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets.apply {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}