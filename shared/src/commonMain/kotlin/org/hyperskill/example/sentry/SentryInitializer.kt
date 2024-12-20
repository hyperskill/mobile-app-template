package org.hyperskill.example.sentry

import io.sentry.kotlin.multiplatform.HttpStatusCodeRange
import io.sentry.kotlin.multiplatform.Sentry
import io.sentry.kotlin.multiplatform.SentryLevel
import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform
import org.hyperskill.example.base.model.PlatformType
import org.hyperskill.example.config.SharedBuildConfig

@Suppress("MagicNumber")
object SentryInitializer {
    fun init(
        platform: Platform,
        buildVariant: BuildVariant
    ) {
        Sentry.configureScope { scope ->
            scope.level = if (buildVariant.isDebug()) {
                SentryLevel.DEBUG
            } else {
                SentryLevel.INFO
            }
        }
        Sentry.init { options ->
            options.diagnosticLevel = if (buildVariant.isDebug()) {
                SentryLevel.INFO
            } else {
                SentryLevel.ERROR
            }
            options.dsn = when (platform.platformType) {
                PlatformType.ANDROID -> SharedBuildConfig.ANDROID_SENTRY_DSN
                PlatformType.IOS -> SharedBuildConfig.IOS_SENTRY_DSN
            }
            options.environment = buildVariant.value
            options.release = platform.releaseName()
            options.attachStackTrace = true
            options.attachScreenshot = true
            options.attachViewHierarchy = true
            options.failedRequestStatusCodes = listOf(
                HttpStatusCodeRange(400, 407),
                HttpStatusCodeRange(409, 599)
            )

            if (buildVariant.isDebug()) {
                options.debug = true
                options.tracesSampleRate = 1.0
            } else {
                options.debug = false
                options.tracesSampleRate = 0.3
            }
        }
    }

    private fun Platform.releaseName(): String =
        "${applicationId}@${versionName}+${versionCode}"
}