package com.goozmo.virtualassistant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Base64;

public class PostClient {

	public static void main(String[] args) throws Exception {

		PostClient http = new PostClient();

//		http.sendGet();
		
		http.sendPost();

	}
	
	// HTTP POST request
	private void sendPost(String postData) throws Exception {
		String url = "http://central.tipflip.co";
		URL obj = new URL(url);
		try {
		

			URL myURL = new URL(url);
			HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
			String userCredentials = "username:password";
			String basicAuth = "Basic " + new String(Base64.encode(userCredentials.getBytes(), 0));
			myURLConnection.setRequestProperty ("Authorization", basicAuth);
			myURLConnection.setRequestMethod("POST");
			myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			myURLConnection.setRequestProperty("Content-Length", "" + Integer.toString(postData.getBytes().length));
			myURLConnection.setRequestProperty("Content-Language", "en-US");
			myURLConnection.setUseCaches(false);
			myURLConnection.setDoInput(true);
			myURLConnection.setDoOutput(true);
		
		
		//print result
		System.out.println(response.toString());
		} catch(IOException e) {
			System.out.println("Error Code : " + con.getErrorStream());
			
		}

	}

}