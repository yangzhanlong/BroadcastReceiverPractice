package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiverOne extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String content = getResultData();
        Toast.makeText(context, "Receiver1:" + content, Toast.LENGTH_SHORT).show();

        // Receiver two 不会接收到广播
        //abortBroadcast();

        setResultData("Send 50 messages");
    }
}
