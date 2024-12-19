package org.hyperskill.example

import org.gradle.accessors.dm.LibrariesForAppVersions
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderConvertible
import org.gradle.kotlin.dsl.accessors.runtime.extensionOf
import org.gradle.plugin.use.PluginDependency

val Project.libs
    get(): LibrariesForLibs = extensionOf(this, "libs") as LibrariesForLibs

val Project.appVersions
    get(): LibrariesForAppVersions = extensionOf(this, "appVersions") as LibrariesForAppVersions

fun PluginManager.alias(notation: Provider<PluginDependency>) {
    apply(notation.get().pluginId)
}

fun PluginManager.alias(notation: ProviderConvertible<PluginDependency>) {
    apply(notation.asProvider().get().pluginId)
}