import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
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
