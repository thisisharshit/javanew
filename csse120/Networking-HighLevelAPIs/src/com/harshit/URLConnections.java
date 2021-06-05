package com.harshit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;


public class URLConnections {
	public static void main(String[] args) {
		try {
			URL url =  new URL("http://example.org");
			
//			BufferedReader inputstream = new BufferedReader(new InputStreamReader(url.openStream()));
//			
//			String line = "";
//			while(line!=null) {
//				line=inputstream.readLine();
//				System.out.println(line);
//			}
//			inputstream.close();
			
			// other way of doing the above thing
			
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true); // configurtaion , read , write
			urlConnection.connect();
			BufferedReader inputstream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = "";
			while(line!=null) {
				line=inputstream.readLine();
				System.out.println(line);
			}
			inputstream.close();
			
			
//			URI uri  = url.toURI();
//			
//			System.out.println("Scheme = "+uri.getScheme());
//			System.out.println("Scheme-Specific part = "+uri.getSchemeSpecificPart());
//			System.out.println("authority = "+uri.getAuthority());
//			System.out.println("User-info = "+uri.getUserInfo());
//			System.out.println("Host = "+uri.getHost());
//			System.out.println("Path = "+uri.getPath());
//			System.out.println("Port = "+uri.getPort());
//			System.out.println("Query = "+uri.getQuery());
//			System.out.println("Fragment = "+uri.getFragment());
			
			
			
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: "+e.getMessage());
		}catch (IOException e) { 
			System.out.println("IOException: "+e.getMessage());
		}
	}
}
