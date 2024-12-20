package org.hyperskill.example.logging.injection

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import org.hyperskill.example.base.model.BuildVariant

internal object LoggerBuilder {
    private const val LOG_TAG = "EXAMPLE_APP"

    fun build(
        buildVariant: BuildVariant
    ): Logger =
        Logger(
            config = StaticConfig(
                logWriterList = listOfNotNull(
                    if (buildVariant == BuildVariant.RELEASE) null else platformLogWriter(),
                    // TODO: Uncomment it once you add real values to SHARED_ANDROID_SENTRY_DSN and SHARED_IOS_SENTRY_DSN in the /config/production.properties file
                    // SentryLogWriter(SentryMessageStringFormatterImpl)
                ),
                minSeverity = if (buildVariant == BuildVariant.RELEASE) {
                    Severity.Info
                } else {
                    Severity.Debug
                }
            ),
            tag = LOG_TAG
        )
}