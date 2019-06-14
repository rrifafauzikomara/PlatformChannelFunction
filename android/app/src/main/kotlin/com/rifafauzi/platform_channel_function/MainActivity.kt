package com.rifafauzi.platform_channel_function

import android.os.Bundle

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {

  private val CHANNEL = "flutter.native/helper"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)

    MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
      if (call.method == "helloFromNativeCode") {
        val greetings = helloFromNativeCode()
        result.success(greetings)
      }
    }
  }

  private fun helloFromNativeCode(): String {
    return "Hello from Native Android Code";
  }

}
