package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiverTwo extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String content = getResultData();
        Toast.makeText(context, "Receiver2:" + content, Toast.LENGTH_SHORT).show();
    }
}
