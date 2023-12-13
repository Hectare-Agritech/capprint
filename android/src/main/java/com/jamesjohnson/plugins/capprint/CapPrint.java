package com.jamesjohnson.plugins.capprint;

import android.util.Log;

public class CapPrint {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public String print() {
        Log.i("CapPrint", "print");
        return "Print";
    }
}
