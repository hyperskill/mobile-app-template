import Foundation
import shared

extension BuildVariant {
    static var current: BuildVariant {
        #if DEBUG
        return .debug
        #else
        return .theRelease
        #endif
    }
}
