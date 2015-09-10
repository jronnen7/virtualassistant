package com.goozmo.virtualassistant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import net.iharder.jpushbullet2.PushbulletClient;
import net.iharder.jpushbullet2.PushbulletException;



<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;

public class PostClient  extends Activity{
=======
//		http.sendGet();
		
		http.sendPost(new String(""));
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String value = intent.getStringExtra("key"); //if it's a string you stored.
		
		sendPost(value);
	}

	// HTTP POST request
	//curl --header 'Access-Token: <your_access_token_here>' -X POST https://api.pushbullet.com/v2/pushes --header 'Content-Type: application/json' --data-binary '{"type": "note", "title": "Note Title", "body": "Note Body"}'
	private void sendPost(String api_key)  {
//        PushbulletClient client = new PushbulletClient( authTocken );
//        String result = null;
//		try {
//			result = client.sendNote(null, "My First Push", "Great library. All my devices can see this!");
//			System.out.println( "Result: " + result );
//		} catch (PushbulletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	    final SSLSocketFactory sslSocketFactory = getSSL();

	    final HttpsURLConnection connection = (HttpsURLConnection) new URL(
	            "https://www.pushbullet.com/api/devices").openConnection();
	    connection.setSSLSocketFactory(sslSocketFactory);

	    connection.setRequestMethod("GET");

	    connection.setUseCaches(false);
	    connection.setDoInput(true);
	    connection.setDoOutput(true);

	    final String authStr = api_key + ":";
	    final byte[] authByteEncoded = authStr.getBytes("utf-8");
	    final String authEncoded = Base64.encodeToString(authByteEncoded, Base64.DEFAULT);
	    connection.setRequestProperty("Authorization", "Basic " + authEncoded);

	    final InputStream is = connection.getInputStream();
	    final BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    String line;
	    final StringBuffer response = new StringBuffer();
	    while ((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');


	    }
	    rd.close();
	    System.out.println(response.toString());
		}catch (Exception e) {
			
		}
}

	

