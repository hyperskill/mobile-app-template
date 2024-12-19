import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        let commonComponent = IosAppGraphProvider.shared.provideAppGraph().commonComponent
        let osVersion = commonComponent.platform.osVersion
        let versionCode = commonComponent.platform.versionName
        let text = "Hello, \(osVersion) \(versionCode)"
		Text(text)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
