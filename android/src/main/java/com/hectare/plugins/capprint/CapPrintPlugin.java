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

        PrintDocumentAdapter printDocumentAdapter = getBridge().getWebView().createPrintDocumentAdapter("Hectare Document");
        printManager.print("Hectare Document", printDocumentAdapter, new PrintAttributes.Builder().build());
      }
    });

    call.resolve();
  }
}
