phonegap-plugin-brightness
==========================

A phonegap 3.x plugin for brightness control within android and ios.
Also recently I have added the function for keep screen on.

Installing
======
You may use phonegap CLI as follows:

<pre>
➜ phonegap local plugin add https://github.com/fiscal-cliff/phonegap-plugin-brightness.git
[phonegap] adding the plugin: https://github.com/fiscal-cliff/phonegap-plugin-brightness.git
[phonegap] successfully added the plugin
</pre>

Using
====
The code below can be placed into script tag.

```javascript
		document.addEventListener('deviceready', onDeviceReady);
		function onDeviceReady() {
			window.brightness = cordova.require("cordova.plugin.Brightness.Brightness");
		}
		function setBrightness(value) {
			// value should be float in range from 0 to 1.
			brightness.setBrightness(value, win, fail);
		}
		function getBrightness() {
			// win([-1,0-1]) float 0-1 is a brightness level, -1 represents a system default
			brightness.getBrightness( win, fail);
		}
		function win(status) {
			alert('Message: ' + status);
		}
		function fail(status) {
			alert('Error: ' + status);
		}
```

You may also prevent a sleep (or keep screen on).

```javascript
		// prevents sleep
		brightness.setKeepScreenOn(true);
		// returns normal behavior
		pluginService.brightness.setKeepScreenOn(false);
```
