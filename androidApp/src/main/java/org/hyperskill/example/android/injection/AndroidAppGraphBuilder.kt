package org.hyperskill.example.android.injection

import android.content.Context
import android.os.Build
import org.hyperskill.example.android.BuildConfig
import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform
import org.hyperskill.example.base.model.PlatformType

object AndroidAppGraphBuilder {
    fun build(context: Context): AndroidAppGraph =
        AndroidAppGraph(
            context = context,
            platform = buildPlatform(),
            buildVariant = BuildVariant.getByValue(BuildConfig.BUILD_TYPE)!!
        )

    private fun buildPlatform(): Platform =
        Platform(
            platformType = PlatformType.ANDROID,
            osVersion = "Android ${Build.VERSION.SDK_INT}",
            versionName = BuildConfig.VERSION_NAME,
            versionCode = BuildConfig.VERSION_CODE.toString(),
            applicationId = BuildConfig.APPLICATION_ID
        )
}