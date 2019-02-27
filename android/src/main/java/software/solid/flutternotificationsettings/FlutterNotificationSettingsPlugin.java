package software.solid.flutternotificationsettings;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterNotificationSettingsPlugin */
public class FlutterNotificationSettingsPlugin implements MethodCallHandler {
  private static Context context;


  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_notification_settings");
    context = registrar.context();
    channel.setMethodCallHandler(new FlutterNotificationSettingsPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method) {
      case "getPlatformVersion":
        result.success("Android " + android.os.Build.VERSION.RELEASE);
        break;
      case "check_notification_permission":
        boolean isNotificationsEnabled = NotificationManagerCompat.from(context).areNotificationsEnabled();
        result.success(isNotificationsEnabled);
        break;
      default:
        result.notImplemented();
        break;
    }
  }
}
