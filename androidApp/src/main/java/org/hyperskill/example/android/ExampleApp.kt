package org.hyperskill.example.android

import android.app.Application
import org.hyperskill.example.android.base.model.AndroidBuildVariant
import org.hyperskill.example.android.base.model.AndroidPlatform
import org.hyperskill.example.android.framework.isMainProcess
import org.hyperskill.example.android.injection.AndroidAppGraph

class ExampleApp : Application() {
    companion object {
        private var _application: ExampleApp? = null
        private val application: ExampleApp
            get() = requireNotNull(_application) {
                "Application is not initialized yet"
            }

        fun graph(): AndroidAppGraph =
            requireNotNull(application.graph) {
                "Graph is not initialized yet"
            }
    }

    private var graph: AndroidAppGraph? = null

    override fun onCreate() {
        super.onCreate()
        if (!isMainProcess) return

        // TODO: Uncomment it once you add real value to SHARED_ANDROID_SENTRY_DSN in /config/production.properties file
        /*SentryInitializer.init(
            platform = AndroidPlatform,
            buildVariant = AndroidBuildVariant
        )*/

        _application = this

        graph = AndroidAppGraph(
            context = this,
            platform = AndroidPlatform,
            buildVariant = AndroidBuildVariant
        )
    }
}