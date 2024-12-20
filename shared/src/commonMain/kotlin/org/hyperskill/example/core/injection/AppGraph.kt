package org.hyperskill.example.core.injection

import org.hyperskill.example.base.injection.CommonComponent
import org.hyperskill.example.logging.injection.LoggerComponent
import org.hyperskill.example.network.injection.NetworkComponent

interface AppGraph {
    val commonComponent: CommonComponent
    val loggerComponent: LoggerComponent
    val networkComponent: NetworkComponent
}