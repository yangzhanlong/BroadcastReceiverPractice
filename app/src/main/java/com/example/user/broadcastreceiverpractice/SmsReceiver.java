package com.example.user.broadcastreceiverpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver{
    //当短信到来的时候执行
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取发送者的号码 和发送内容
        Object []objects = (Object[]) intent.getExtras().get("pdus");

        for (Object obj : objects) {
            //[1]获取smsmessage实例
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
            //[2]获取发送短信的内容
            String messageBody = smsMessage.getMessageBody();
            String address = smsMessage.getOriginatingAddress();
            System.out.println("body:"+messageBody+"-----"+address);
        }
    }
}
