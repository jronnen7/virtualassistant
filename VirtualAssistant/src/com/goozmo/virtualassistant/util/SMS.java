package com.goozmo.virtualassistant.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

public class SMS extends Activity 
{
	private Context ctx;
	private SmsManager sms;
	public SMS (Context context) {
		ctx = context;
		sms = SmsManager.getDefault();
	}
    public void sendSms(String phoneNumber, String message)
    {        
        PendingIntent pendI = PendingIntent.getActivity(ctx, 0,
            new Intent(ctx, ctx.getClass()), 0);                
        sms.sendTextMessage(phoneNumber, null, message, pendI, null);        
    }    
}
