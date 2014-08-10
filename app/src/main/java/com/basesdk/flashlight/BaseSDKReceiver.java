package com.basesdk.flashlight;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.basesdk.api.BrainsAPI;
import com.basesdk.api.BrainsIntent;

/**
 * Receiver that listens to Intents coming from BaseSDK.
 */
public class BaseSDKReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    // Listens for sudden lights off event from BaseSdk.
    if (BrainsIntent.ACTION_SUDDEN_LIGHTS_OFF.equals(action)){
      // Show the flashlight only if the user is not driving.
      if(BrainsAPI.getLastKnownActivity() != BrainsIntent.USER_ACTIVITY_EVENT_IN_VEHICLE){
        Intent flashlightIntent = new Intent(context, MainActivity.class);
        flashlightIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(flashlightIntent);
      }
    }
  }
}
