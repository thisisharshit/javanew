package com.harshit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ApacheTest {
	public static void main(String[] args) {
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet request = new HttpGet("http://example.org");
		request.addHeader("User-Agent","Chrome");
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(request);
			System.out.println("response code = "+response.getStatusLine().getStatusCode());
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line;
			while((line=inputReader.readLine())!=null) {
				System.out.println(line);
			}
			inputReader.close();
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}finally {
			try {
				response.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
