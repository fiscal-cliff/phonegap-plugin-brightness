package org.apache.cordova.plugin.Brightness;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;

/**
 * @author Evgeniy Lukovsky
 *
 */
public class BrightnessPlugin extends CordovaPlugin {
	public enum Action{
		setBrightness;
		getBrightness
	}


	/* (non-Javadoc)
	 * @see org.apache.cordova.CordovaPlugin#execute(java.lang.String, org.json.JSONArray, org.apache.cordova.CallbackContext)
	 */
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		System.out.println("plugin has been started");
		boolean result = false;

		switch(Action.valueOf(action)){
		case setBrightness: result = true;
			setBrightness(args, callbackContext);
			break;
		}
		case getBrightness: result = true;
			getBrightness(args, callbackContext);
			break;
		}
		return result;
	}

	/**
	 * @param args
	 * @param callbackContext
	 * @return
	 */
	private boolean setBrightness(JSONArray args, CallbackContext callbackContext) {
		String filePath = null;
		try {
			Activity activity = cordova.getActivity();
			WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
			String value = args.getString(0);
			double brightness = Double.parseDouble(value);
			layoutParams.screenBrightness = brightness;
			activity.getWindow().setAttributes(layoutParams);
			callbackContext.success("OK");

		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
			System.out.println(e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}
		System.out.println("All went fine.");
		//callbackContext.success(filePath);
		return true;
	}

	/**
	 * @param args
	 * @param callbackContext
	 * @return
	 */
	private boolean getBrightness(JSONArray args, CallbackContext callbackContext) {
		String filePath = null;
		try {
			Activity activity = cordova.getActivity();
			WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
			String value = args.getString(0);
			Double brightness = layoutParams.screenBrightness;
			callbackContext.success(brightness.toString());

		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
			System.out.println(e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}
		System.out.println("All went fine.");
		return true;
	}

}
