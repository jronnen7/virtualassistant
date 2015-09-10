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
		
		http.sendPost(new String(""));

	}
	
	// HTTP POST request
	private void sendPost(String postData) throws Exception {
		String url = "http://central.tipflip.co";
		URL obj = new URL(url);

	}

}