package org.hyperskill.example.core.injection

import org.hyperskill.example.base.injection.CommonComponent
import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform

abstract class BaseAppGraph(
    platform: Platform,
    buildVariant: BuildVariant
) : AppGraph {
    override val commonComponent: CommonComponent by lazy(LazyThreadSafetyMode.NONE) {
        CommonComponent(platform, buildVariant)
    }
}