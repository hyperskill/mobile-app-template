import org.gradle.accessors.dm.LibrariesForAppVersions
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.ProviderConvertible
import org.gradle.kotlin.dsl.the
import org.gradle.plugin.use.PluginDependency

// Workaround for https://github.com/gradle/gradle/issues/15383
val Project.libs: LibrariesForLibs
    get() = the<LibrariesForLibs>()

// Workaround for https://github.com/gradle/gradle/issues/15383
val Project.appVersions
    get() = the<LibrariesForAppVersions>()