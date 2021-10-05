package software.solid.flutternotificationsettings;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/** FlutterNotificationSettingsPlugin */
public class FlutterNotificationSettingsPlugin implements MethodCallHandler, FlutterPlugin {
  private static Context context;
  private MethodChannel channel;


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

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    channel = new MethodChannel(binding.getBinaryMessenger(), "flutter_notification_settings");
    channel.setMethodCallHandler(new FlutterNotificationSettingsPlugin());
    context = binding.getApplicationContext();
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
    channel = null;  }
}
