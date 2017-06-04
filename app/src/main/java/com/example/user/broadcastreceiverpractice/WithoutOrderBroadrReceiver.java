package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WithoutOrderBroadrReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String content = intent.getStringExtra("content");
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
