# Flutter Notification Settings
This plugin allows you to check if notifications are enabled on your device.

To learn more about the notifications, follow the link: 
[for Android](https://developer.android.com/guide/topics/ui/notifiers/notifications) and 
[for iOS](https://developer.apple.com/design/human-interface-guidelines/ios/system-capabilities/notifications).


## Getting started
To check if notifications are enabled just copy this code or follow [example](https://github.com/solid-software/flutter_notification_settings/tree/master/example):

```dart
bool isNotificationsEnabled = await FlutterNotificationSettings.notificationsEnabled;
```
 For checking your Android Version just add to your code: 
```dart
String androidVersion = await FlutterNotificationSettings.platformVersion;
```

## Current issues
Current issues list [is here](https://github.com/solid-software/flutter_notification_settings/issues).   
Found a bug? [Open the issue](https://github.com/solid-software/flutter_notification_settings/issues/new).