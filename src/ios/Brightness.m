

#import "Brightness.h"
#import "UIScreen.h"

@implementation Brightness : CDVPlugin


- (void)getBrightness:(CDVInvokedUrlCommand *)command
{
    CDVPluginResult * pluginResult = nil;
    float brightness = [UIScreen mainScreen].brightness;
    NSString *result = [NSString stringWithFormat:@"%f", brightness];
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:result];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    [UIScreen mainScreen].brightness = 0;
}

- (void)setBrightness:(CDVInvokedUrlCommand *)command
{
    CDVPluginResult * pluginResult = nil;
    NSString *value = [arguments objectAtIndex:0];
    float brightness = [value floatValue];
    [UIScreen mainScreen].brightness = brightness;
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"OK";
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end