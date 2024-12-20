package org.hyperskill.example.core.injection

import org.hyperskill.example.base.injection.CommonComponent
import org.hyperskill.example.injection.LoggerComponent

interface AppGraph {
    val commonComponent: CommonComponent
    val loggerComponent: LoggerComponent
}