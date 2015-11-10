package com.goozmo.virtualassistant;

import java.util.HashMap;
import java.util.Locale;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.widget.Toast;



// This class is responsible for talking
public class Speaker implements OnInitListener {

    private TextToSpeech tts;
    
    private boolean ready = false;
     
    public Speaker(Context context){
        tts = new TextToSpeech(context, this);      
    }   
     

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.US);
            ready = true;
        }
        else{
            ready = false;
        }
    }

	public void WelcomeMessage() {
		Speak("Welcome to Goozmo! How can we help you today?");
	}
	
	public void PleaseWaitMessage() {
		Speak("Welcome to Goozmo! How can we help you today?");
	}
	
	public void Speak(String string) {
		if(ready) {
	        HashMap<String, String> hash = new HashMap<String,String>();
	        hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM, 
	                String.valueOf(AudioManager.STREAM_NOTIFICATION));
	        tts.speak(string, TextToSpeech.QUEUE_ADD, hash);
	    }
	}
	// Free up resources
	public void Destroy(){
	    tts.shutdown();
	}


	
}
