package com.harshit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HTTPUrlConnection {
	public static void main(String[] args) {
		try {
			URL url =  new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
			
			HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-agent", "Chrome");
			connection.setReadTimeout(30000);
			
			int responsecode = connection.getResponseCode();
			System.out.println("Response code = "+responsecode);
			
			if(responsecode!=200) {
				System.out.println("error reading web page");
				System.out.println(connection.getResponseMessage());
				return ;
			}
			
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line=inputReader.readLine())!=null) {
				System.out.println(line);
			}
			inputReader.close();
			
			
			
			

//			URLConnection urlConnection = url.openConnection();
//			urlConnection.connect();
//			BufferedReader inputstream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//			
//			Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//			for(Map.Entry<String, List<String>> entry: headerFields.entrySet()){
//				String key = entry.getKey();
//				List<String> value = entry.getValue();
//				System.out.println("-----Key = "+key);
//				for(String string:value) {
//					System.out.println("Value = "+value);
//				}
//			}
			
			
			
			
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: "+e.getMessage());
		}catch (IOException e) { 
			System.out.println("IOException: "+e.getMessage());
		}
	}
}
