import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CapPrintPlugin)
public class CapPrintPlugin: CAPPlugin {
    private let implementation = CapPrint()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
    
    @objc func nativePrint(_ call: CAPPluginCall) {
        guard let webView = self.webView else { return }
        let jsPrint = "print()"
        
        DispatchQueue.main.async {
            webView.evaluateJavaScript(jsPrint, completionHandler: nil)
        }
    }
}
