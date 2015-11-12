package com.goozmo.virtualassistant;

import java.util.ArrayList;
import java.util.Locale;

import com.goozmo.virtualassistant.util.Emailer;
import com.goozmo.virtualassistant.util.SMS;
import com.goozmo.virtualassistant.util.Speaker;
import com.goozmo.virtualassistant.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class MainActivity extends Activity {
	
	private final int REQ_CODE_SPEECH_INPUT = 100;	

    private TextView txtSpeechInput;
    private Speaker speaker;
    private Emailer emailer;
    private SMS sms;
    
    ArrayList<String> mResponseText;
    private boolean mTextOwner; // if set to true text owner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

      
        speaker = new Speaker(this);
        sms = new SMS(this);
        emailer = new Emailer(this);
        
        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        GooButtonListener buttonListener = new GooButtonListener();
        
        findViewById(R.id.home_screen_button1).setOnClickListener(
        		buttonListener);
        findViewById(R.id.home_screen_button2).setOnClickListener(
        		buttonListener);
        findViewById(R.id.home_screen_button3).setOnClickListener(
        		buttonListener);

    }

   private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }
   
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);

       switch (requestCode) {
       case REQ_CODE_SPEECH_INPUT: {
           if (resultCode == RESULT_OK && null != data) {

        	   mResponseText = data.getStringArrayListExtra(
        			   RecognizerIntent.EXTRA_RESULTS);
               txtSpeechInput.setText(mResponseText.get(0));
     
               if(mTextOwner) {
            	   speaker.Speak("I think you said " + 
            			   mResponseText.get(0) +", but I am just a robot. Let me text my owner");
       				sms.sendSms("3209054092", mResponseText.get(0));  
       				String emailStr = new String("Virtual Assistant - <br>");
       				for(int i=0;i<mResponseText.size();i++) {
       					emailStr += mResponseText.get(i) + "<br>";
       				}
       				emailer.sendEmail(emailStr);
               }
               finish();
           }
           break;
       }

       }
   }
    
    private class GooButtonListener implements OnClickListener {
    	
    	public GooButtonListener() {
    		
    	}
		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.home_screen_button1) {
				speaker.WelcomeMessage();
			} else if(v.getId() == R.id.home_screen_button2) {
				mTextOwner = false;
				promptSpeechInput();
			} else if(v.getId() == R.id.home_screen_button3) {
				mTextOwner = true;
				promptSpeechInput();
			}
		}	
    }
}
