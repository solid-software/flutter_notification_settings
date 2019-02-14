import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter_notification_settings/flutter_notification_settings.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  bool isNotificationsEnabled;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    var _isNotificationsEnabled = await FlutterNotificationSettings.notificationsEnabled;
    setState(() {
      isNotificationsEnabled = _isNotificationsEnabled;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Allowed to recieve notifications from this app: $isNotificationsEnabled\n'),
        ),
      ),
    );
  }
}
