package com.example.user.broadcastreceiverpractice;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ScreenReceiver screenReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.ed);

        // 动态的去注册广播接收者
        screenReceiver = new ScreenReceiver();
        //创建IntentFilter 对象
        IntentFilter filter = new IntentFilter();
        //添加要注册的action
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(screenReceiver, filter);
    }

    public void click (View view) {
        String number = editText.getText().toString().trim();
        SharedPreferences sp = getSharedPreferences("config", 0);
        sp.edit().putString("number", number).commit();

        Toast.makeText(this, "Save success", Toast.LENGTH_SHORT).show();
    }

    // 发送无序广播
    public void send_broadcast_without_order (View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.broadcast_without_order");
        intent.putExtra("content", "News begin at 8pm");
        sendBroadcast(intent);
    }

    // 发送有序广播
    public void send_order_broadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.send_order_broadcast");

        /**
         * intent  意图 '
         *
         * receiverPermission   接收的权限
         *
         * resultReceiver 最终的receiver
         *
         * scheduler  handler
         *
         * initialCode  初始码
         * initialData  初始化数据
         */
        sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 1, "Send 100 messages", null);
    }

    @Override
    protected void onDestroy() {
        //当activity 销毁的时候要取消注册广播接收者
        unregisterReceiver(screenReceiver);
        super.onDestroy();
    }
}
