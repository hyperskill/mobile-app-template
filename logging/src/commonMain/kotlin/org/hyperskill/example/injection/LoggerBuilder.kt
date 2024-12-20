package org.hyperskill.example.injection

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
                    if (buildVariant == BuildVariant.RELEASE) null else platformLogWriter()
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