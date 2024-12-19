package org.hyperskill.example.core.model

data class Platform(
    val platformType: PlatformType,
    val osVersion: String,
    val versionName: String,
    val versionCode: String,
    val applicationId: String
)