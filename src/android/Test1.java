package com.cordova.plugin.Test1;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.helloworldlib.HelloWorld;

/**
 * This class echoes a string called from JavaScript.
 */
public class Test1 extends CordovaPlugin {

    private static HelloWorld hw = new HelloWorld();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message + ":" + hw.getEnglish());
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
