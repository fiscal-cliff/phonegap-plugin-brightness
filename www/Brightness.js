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

	Brightness.prototype.setBrightness = function( successCallback, errorCallback) 
	{
		return cordova.exec(successCallback, errorCallback, "Brightness", "setBrightness", []);
	};

	module.exports= new Brightness();

