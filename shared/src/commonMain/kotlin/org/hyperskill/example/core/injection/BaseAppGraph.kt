package org.hyperskill.example.core.injection

import org.hyperskill.example.base.injection.CommonComponent
import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform
import org.hyperskill.example.injection.LoggerComponent

abstract class BaseAppGraph(
    platform: Platform,
    buildVariant: BuildVariant
) : AppGraph {
    override val commonComponent: CommonComponent by lazy(LazyThreadSafetyMode.NONE) {
        CommonComponent(platform, buildVariant)
    }
    override val loggerComponent: LoggerComponent by lazy(LazyThreadSafetyMode.NONE) {
        LoggerComponent(buildVariant)
    }
}