package com.example.a02_5_broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MainReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        boolean isOn = intent.getBooleanExtra("state", false);
        Toast.makeText(context, "Airplane mode " + (isOn ? "ON" : "OFF"), Toast.LENGTH_SHORT).show();
    }
}
