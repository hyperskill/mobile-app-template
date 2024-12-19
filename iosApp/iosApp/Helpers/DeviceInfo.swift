import Foundation

enum DeviceInfo {
    static var operatingSystemName: String {
        #if os(iOS)
        "iOS"
        #elseif os(macOS)
        "macOS"
        #elseif os(tvOS)
        "tvOS"
        #elseif os(watchOS)
        "watchOS"
        #elseif os(visionOS)
        "visionOS"
        #elseif os(Linux)
        "Linux"
        #else
        "Unknown OS"
        #endif
    }

    static var operatingSystemVersion: OperatingSystemVersion {
        ProcessInfo.processInfo.operatingSystemVersion
    }

    static var operatingSystemVersionString: String {
        let operatingSystemVersion = DeviceInfo.operatingSystemVersion
        return [
            "\(operatingSystemVersion.majorVersion)",
            "\(operatingSystemVersion.minorVersion)",
            "\(operatingSystemVersion.patchVersion)"
        ].joined(separator: ".")
    }
}
