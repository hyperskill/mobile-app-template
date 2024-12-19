package org.hyperskill.example.core.injection

import org.hyperskill.example.core.model.BuildVariant
import org.hyperskill.example.core.model.Platform

object IosAppGraphProvider {
    private var instance: IosAppGraph? = null

    fun initializeAppGraph(
        platform: Platform,
        buildVariant: BuildVariant
    ) {
        if (instance == null) {
            instance = IosAppGraph(
                platform = platform,
                buildVariant = buildVariant
            )
        } else {
            error("AppGraph is already initialized")
        }
    }

    fun provideAppGraph(): SharedIosAppGraph =
        instance ?: error("AppGraph is not initialized")
}