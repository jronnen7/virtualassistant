package com.goozmo.virtualassistant.util;

import com.goozmo.virtualassistant.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;


public class Emailer {
	private Context mCtx;
    public Emailer(Context context){
    	mCtx = context;      
    }   
    public void sendEmail(String emailString) {
    	Intent i = new Intent(Intent.ACTION_SEND);
    	i.setType("message/rfc822");
    	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"jared@goozmo.com","support@goozmo.com"});
    	i.putExtra(Intent.EXTRA_SUBJECT, "Virtual Assistant - ");
    	i.putExtra(Intent.EXTRA_TEXT   , emailString);
    	try {
    	    mCtx.startActivity(Intent.createChooser(i, "Send mail..."));
    	} catch (android.content.ActivityNotFoundException ex) {
    	    //Toast.makeText(mCtx.getClass(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
    	}
     }
     
}
