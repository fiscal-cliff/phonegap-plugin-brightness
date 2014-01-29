 /*
 * @author Evgeniy Lukovsky
 * */

	var exec = require('cordova/exec');

	var Brightness=function(){
	};

	Brightness.prototype.getBrightness = function( successCallback, errorCallback) 
	{
		return cordova.exec(successCallback, errorCallback, "Brightness", "getBrightness", []);
	};

	Brightness.prototype.setBrightness = function(value, successCallback, errorCallback) 
	{
		return cordova.exec(successCallback, errorCallback, "Brightness", "setBrightness", [value]);
	};

	Brightness.prototype.setKeepScreenOn = function(value, successCallback, errorCallback) 
	{
		return cordova.exec(successCallback, errorCallback, "Brightness", "setKeepScreenOn", [value]);
	};

	module.exports= new Brightness();

