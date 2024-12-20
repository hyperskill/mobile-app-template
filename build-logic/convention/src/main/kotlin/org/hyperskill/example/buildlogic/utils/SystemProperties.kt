package org.hyperskill.example.buildlogic.utils

import org.gradle.api.Project

object SystemProperties {
    fun get(project: Project, name: String): String? =
        System.getenv(name) ?: project.properties[name] as? String

    fun isCI(): Boolean =
        System.getenv("CI")?.toBoolean() ?: false
}