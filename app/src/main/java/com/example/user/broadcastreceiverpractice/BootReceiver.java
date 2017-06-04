package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver{

    //当手机重新启动的时候调用
    @Override
    public void onReceive(Context context, Intent intent) {
        //在这个方法里面开启activity
        Intent intent2 = new Intent(context, MainActivity.class);

        //☆☆☆注意 不能在广播接收者里面直接开启activity  需要添加一个标记 添加一个任务栈的标记
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //开启activity
        context.startActivity(intent2);
    }
}
