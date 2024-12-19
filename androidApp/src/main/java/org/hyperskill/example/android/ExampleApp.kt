package org.hyperskill.example.android

import android.app.Application
import org.hyperskill.example.android.base.isMainProcess
import org.hyperskill.example.android.injection.AndroidAppGraph
import org.hyperskill.example.android.injection.AndroidAppGraphBuilder

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

        _application = this

        graph = AndroidAppGraphBuilder.build(this)
    }
}