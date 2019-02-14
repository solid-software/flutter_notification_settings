import 'dart:async';

import 'package:flutter/services.dart';

class FlutterNotificationSettings {
  static const MethodChannel _channel =
      const MethodChannel('flutter_notification_settings');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<bool> get notificationsEnabled async{
    var isNotificationsEnabled = await _channel.invokeMethod('check_notification_permission');
    return isNotificationsEnabled;
  }
}
