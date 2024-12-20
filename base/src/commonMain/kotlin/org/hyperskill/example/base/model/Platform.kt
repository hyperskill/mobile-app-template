package org.hyperskill.example.base.model

data class Platform(
    val platformType: PlatformType,
    val osVersion: String,
    val versionName: String,
    val versionCode: String,
    val applicationId: String
)