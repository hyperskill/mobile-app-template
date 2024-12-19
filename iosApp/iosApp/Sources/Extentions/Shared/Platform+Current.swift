import Foundation
import shared

extension Platform {
    static var current: Platform {
        Platform(
            platformType: .ios,
            osVersion: "\(DeviceInfo.operatingSystemName) \(DeviceInfo.operatingSystemVersionString)",
            versionName: MainBundleInfo.shortVersionString ?? "N/A",
            versionCode: MainBundleInfo.buildNumberString ?? "N/A",
            applicationId: MainBundleInfo.identifier ?? "N/A"
        )
    }
}
