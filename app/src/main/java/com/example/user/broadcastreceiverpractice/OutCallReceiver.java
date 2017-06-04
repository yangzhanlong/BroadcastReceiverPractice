package com.example.user.broadcastreceiverpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutCallReceiver extends BroadcastReceiver{
    // 当进行外拨电话的时候 调用
    @Override
    public void onReceive(Context context, Intent intent) {
        // 获取用户输入的ip号码
        SharedPreferences sp = context.getSharedPreferences("config", 0);
        String number = sp.getString("number", "");

        // 获取当前拨打的电话号码
        String currentNumber = getResultData();
        if (currentNumber.startsWith("0")) {

            // 修改拨打电话的号码
            setResultData(number + currentNumber);
        }
    }
}
