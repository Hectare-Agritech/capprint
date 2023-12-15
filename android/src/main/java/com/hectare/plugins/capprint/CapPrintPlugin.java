package com.hectare.plugins.capprint;

import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CapPrint")
public class CapPrintPlugin extends Plugin {

  private CapPrint implementation = new CapPrint();

  @PluginMethod
  public void echo(PluginCall call) {
    String value = call.getString("value");

    JSObject ret = new JSObject();
    ret.put("value", implementation.echo(value));
    call.resolve(ret);
  }

  @PluginMethod
  public void nativePrint(PluginCall call) {
    getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        PrintManager printManager = (PrintManager) getContext().getSystemService(getContext().PRINT_SERVICE);
        PrintAttributes.Builder printBuilder = new PrintAttributes.Builder();
        PrintDocumentAdapter printDocumentAdapter = getBridge().getWebView().createPrintDocumentAdapter("Hectare Document");

        printBuilder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);
        printBuilder.setMinMargins(PrintAttributes.Margins.NO_MARGINS);

        printManager.print("Hectare Document", printDocumentAdapter, printBuilder.build());
      }
    });

    call.resolve();
  }
}
