package org.hyperskill.edvancium.redux

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope

class CompletableCoroutineActionDispatcherConfig(
    override val parentScope: CoroutineScope? = null
) : CompletableCoroutineActionDispatcher.ScopeConfigOptions {
    override val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            if (throwable !is CancellationException) {
                throw throwable // rethrow if not cancellation exception
            }
        }
}