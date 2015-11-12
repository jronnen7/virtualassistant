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
        String[] TO = {"jared@goozmo.com"};
        String[] CC = {"support@goozmo.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Virtual Assistant Application");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailString);
        
        try {
           mCtx.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        }
        catch (android.content.ActivityNotFoundException ex) {
           Toast.makeText(mCtx, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
     }
     
}
