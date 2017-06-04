package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppStateReceiver extends BroadcastReceiver{
    //当有新的应用被安装 了  或者有应用被卸载了  这个方法调用
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取当前广播事件类型
        String action = intent.getAction();

        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            System.out.println("应用安装了");
        }else if("android.intent.action.PACKAGE_REMOVED".equals(action)){
            System.out.println("应用卸载了"+intent.getData());
        }
    }
}
