package org.hyperskill.example.logging.injection

import co.touchlab.kermit.Logger
import org.hyperskill.example.base.model.BuildVariant

fun LoggerComponent(
    buildVariant: BuildVariant
): LoggerComponent =
    LoggerComponentImpl(buildVariant)

private class LoggerComponentImpl(
    buildVariant: BuildVariant
) : LoggerComponent {
    override val logger: Logger =
        LoggerBuilder.build(buildVariant)
}