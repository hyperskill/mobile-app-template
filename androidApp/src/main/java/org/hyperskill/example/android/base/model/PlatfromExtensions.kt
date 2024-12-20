package org.hyperskill.example.android.base.model

import android.os.Build
import org.hyperskill.example.android.BuildConfig
import org.hyperskill.example.base.model.Platform
import org.hyperskill.example.base.model.PlatformType

val AndroidPlatform: Platform =
    Platform(
        platformType = PlatformType.ANDROID,
        osVersion = "Android ${Build.VERSION.SDK_INT}",
        versionName = BuildConfig.VERSION_NAME,
        versionCode = BuildConfig.VERSION_CODE.toString(),
        applicationId = BuildConfig.APPLICATION_ID
    )