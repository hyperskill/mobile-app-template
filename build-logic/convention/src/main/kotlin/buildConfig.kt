import com.github.gmazzo.buildconfig.BuildConfigExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.buildConfigField
import org.hyperskill.example.buildlogic.utils.SystemProperties
import org.jetbrains.kotlin.konan.properties.loadProperties
import org.jetbrains.kotlin.konan.properties.propertyString

fun BuildConfigExtension.addBuildConfigFieldsByPrefix(
    project: Project,
    pathToPropertiesFile: String,
    prefix: String,
    buildConfigBlock: BuildConfigExtension.() -> Unit = {}
) {
    val properties = loadProperties(pathToPropertiesFile)
    properties.keys.forEach { name ->
        name as String
        if (name.startsWith(prefix)) {
            val filteredName = name.substringAfter("_")
            val propertyValue = SystemProperties.get(project, name) ?: properties.propertyString(name)
            buildConfigField(
                name = filteredName,
                value = requireNotNull(propertyValue) {
                    "Property $name is not set"
                }
            )
        }
    }
    buildConfigBlock()
}