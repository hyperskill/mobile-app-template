import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        // TODO: Uncomment it once you add real value to SHARED_IOS_SENTRY_DSN in /config/production.properties file
        //SentryInitializer.shared.doInit(
        //    platform: .current,
        //    buildVariant: .current
        //)

        IosAppGraphProvider.shared.initializeAppGraph(
            platform: .current,
            buildVariant: .current
        )
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
