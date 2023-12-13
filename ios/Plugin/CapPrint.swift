import Foundation

@objc public class CapPrint: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }

    @objc public func nativePrint() -> Void {
    }
}
