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
        
        DispatchQueue.main.async {
            let printController = UIPrintInteractionController.shared

            let printInfo = UIPrintInfo(dictionary: nil)
            printInfo.outputType = .general
            printInfo.jobName = "Web Page Print"
            printController.printInfo = printInfo

            let printFormatter = webView.viewPrintFormatter()
            printController.printFormatter = printFormatter

            printController.present(from: webView.bounds, in: webView, animated: true, completionHandler: nil)
        }
    }
}
