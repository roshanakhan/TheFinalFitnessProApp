package com.example.jerry.navi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

//接收通知点击动作

public class NotificationClickReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent newIntent = new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);
    }
}