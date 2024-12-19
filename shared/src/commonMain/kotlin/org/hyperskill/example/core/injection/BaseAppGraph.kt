package org.hyperskill.example.core.injection

import org.hyperskill.example.core.model.BuildVariant
import org.hyperskill.example.core.model.Platform

abstract class BaseAppGraph(
    platform: Platform,
    buildVariant: BuildVariant
) : AppGraph {
    override val commonComponent: CommonComponent by lazy(LazyThreadSafetyMode.NONE) {
        CommonComponentImpl(platform, buildVariant)
    }
}