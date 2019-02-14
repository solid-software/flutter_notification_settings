#import "FlutterNotificationSettingsPlugin.h"
@import UserNotifications;

@implementation FlutterNotificationSettingsPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"flutter_notification_settings"
            binaryMessenger:[registrar messenger]];
  FlutterNotificationSettingsPlugin* instance = [[FlutterNotificationSettingsPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"getPlatformVersion" isEqualToString:call.method]) {
      result([@"iOS " stringByAppendingString:[[UIDevice currentDevice] systemVersion]]);
    }else if ([@"check_notification_permission" isEqualToString:call.method]){
        UNUserNotificationCenter *center = [UNUserNotificationCenter currentNotificationCenter];
        [center getNotificationSettingsWithCompletionHandler:^(UNNotificationSettings *settings){
            BOOL hasNotificationPermission;
            hasNotificationPermission = settings.badgeSetting == UNAuthorizationStatusAuthorized;
            result([NSNumber numberWithBool:hasNotificationPermission]);
        }];
    } else {
      result(FlutterMethodNotImplemented);
    }
}

@end
