package com.cvte.mail;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpSender {

	private volatile static HttpSender instance;

	private HttpSender() {
	}

	/**
	 * @return HttpSender instance
	 */
	public static HttpSender getInstance() {
		if (instance == null) {
			synchronized (HttpSender.class) {
				if (instance == null) {

					instance = new HttpSender();
				}
			}
		}
		return instance;
	}

	/**
	 * @param mailMessage 短连接形式
	 */
	public static void send(MailMessage mailMessage)
	{
		if(mailMessage==null)
			throw new NullPointerException("MailMessage null is not acceptable ");

		OutputStreamWriter osw = null;
		URL CURL=null;
		try {
			CURL = new URL("http://172.18.81.123:8161/api/message/apiincoming?type=queue");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpURLConnection httpURLConnection=null;
		try {
			httpURLConnection = (HttpURLConnection) CURL.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {

			httpURLConnection.setDoOutput(true);
			//httpURLConnection.setDoInput(false);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setReadTimeout(10000);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			httpURLConnection.connect();

			

			osw = new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8");
			osw.write(mailMessage.toString());
			osw.flush();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				osw.close();
				httpURLConnection.getInputStream().close();//这里是真正发生发送请求的代码
				
			} catch( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			httpURLConnection.disconnect();
		}
	
	}
}
