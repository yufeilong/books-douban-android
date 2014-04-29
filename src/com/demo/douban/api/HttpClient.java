package com.demo.douban.api;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HttpClient 
{
	private static final String BASE_URL = "https://api.douban.com/v2/book/";
	
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	static 
	{
		client.setTimeout(10*1000);
	}
	
	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) 
	{
	    client.get(getAbsoluteUrl(url), params, responseHandler);
	}
	
	public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) 
    {
      client.post(getAbsoluteUrl(url), params, responseHandler);
    }
	 
	private static String getAbsoluteUrl(String relativeUrl) 
	{
	      return BASE_URL + relativeUrl;
	}  
}
