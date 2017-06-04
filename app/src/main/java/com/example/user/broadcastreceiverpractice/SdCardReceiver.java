package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SdCardReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取到当前广播的事件类型
        String action = intent.getAction();

        if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            System.out.println("说明sd卡挂载了 ....");
        }else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
            System.out.println("说明sd卡卸载了 ");
        }
    }
}
