package com.example.user.broadcastreceiverpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver{
    //当我们进行屏幕锁屏和解锁 这个方法执行
    @Override
    public void onReceive(Context context, Intent intent) {

        //获取当前广播的事件类型
        String action = intent.getAction();
        if("android.intent.action.SCREEN_OFF".equals(action)){
            System.out.println("屏幕锁屏了 ");

        }else if ("android.intent.action.SCREEN_ON".equals(action)) {
            System.out.println("屏幕解锁了");
        }
    }
}
