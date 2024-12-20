package org.hyperskill.example.logging.sentry

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Message
import co.touchlab.kermit.Severity
import co.touchlab.kermit.Tag
import io.sentry.kotlin.multiplatform.Sentry
import io.sentry.kotlin.multiplatform.SentryLevel
import io.sentry.kotlin.multiplatform.protocol.Breadcrumb

internal class SentryLogWriter(
    private val sentryMessageStringFormatter: SentryMessageStringFormatter
) : LogWriter() {

    override fun isLoggable(tag: String, severity: Severity): Boolean =
        when (severity) {
            Severity.Verbose,
            Severity.Debug,
            Severity.Assert -> false
            Severity.Info,
            Severity.Warn,
            Severity.Error -> true
        }

    override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
        val formattedMessage = sentryMessageStringFormatter.formatMessage(
            severity = null,
            tag = Tag(tag),
            message = Message(message),
            throwable = throwable
        )

        when (severity) {
            Severity.Info -> captureMessage(formattedMessage, SentryLevel.INFO, throwable)
            Severity.Warn -> captureMessage(formattedMessage, SentryLevel.WARNING, throwable)
            Severity.Error -> captureMessage(formattedMessage, SentryLevel.ERROR, throwable)
            Severity.Debug, Severity.Verbose, Severity.Assert -> {
                // no op
            }
        }
    }

    private fun captureMessage(message: String, level: SentryLevel, throwable: Throwable?) {
        Sentry.captureMessage(message) { scope ->
            scope.level = level
            if (throwable != null) {
                scope.addBreadcrumb(Breadcrumb.error(throwable.toString()))
            }
        }
    }
}