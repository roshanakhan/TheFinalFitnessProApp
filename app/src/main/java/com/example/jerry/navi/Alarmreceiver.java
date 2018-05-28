package com.example.jerry.navi;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class Alarmreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //设置通知内容并在onReceive()这个函数执行时开启
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);

        mBuilder.setWhen(System.currentTimeMillis())
                .setTicker("Exercise reminder")
                .setContentTitle("fitness")
                .setContentText("Keep fitness and ")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(getDefalutIntent(context, PendingIntent.FLAG_UPDATE_CURRENT))
                .setAutoCancel(true)
                .build();

        Notification noti = mBuilder.getNotification();

        manager.notify(1, noti);


        //再次开启LongRunningService这个服务，从而可以
        Intent i = new Intent(context, AlarmService.class);
        context.startService(i);
    }

    /**
     * 构造一个打开通知的Intent
     *
     * @param flags
     * @return
     */
    private PendingIntent getDefalutIntent(Context context, int flags) {
        Intent clickIntent = new Intent(context, NotificationClickReceiver.class); //点击通知之后要发送的广播
        // 第二个参数不能写死，可以写一个随机数或者是时间毫秒数 保证唯一
        int id = (int) (System.currentTimeMillis() / 1000);
        PendingIntent contentIntent = PendingIntent.getBroadcast(context.getApplicationContext(), id, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        return contentIntent;
    }
}
