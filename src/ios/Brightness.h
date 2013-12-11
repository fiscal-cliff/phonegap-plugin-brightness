/**
 * @author Evgeniy Lukovsky
 *
 */


#import <Cordova/CDV.h>

@interface Brightness : CDVPlugin

- (void)getBrightness:(CDVInvokedUrlCommand*)command;
- (void)setBrightness:(CDVInvokedUrlCommand*)command;

@end
