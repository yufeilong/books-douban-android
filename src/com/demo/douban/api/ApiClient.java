package com.demo.douban.api;


import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.graphics.Bitmap;

public class ApiClient 
{	
	/**
	 * 获取网络图片
	 * @param url
	 * @return bitmap
	 */
	public static Bitmap getNetBitmap(String url)
	{
		Bitmap bitmap = null;
		return bitmap;
	}
	
	/**
	 * 获取图书详细信息
	 * @param id
	 */
	public static void getBookDetail(String id, JsonHttpResponseHandler jsonHandler)
	{	
		HttpClient.get(id, null, jsonHandler);
	}
	
	/**
	 * 获取推荐图书
	 * @param tag
	 * @param jsonHandler
	 */
	public static void getRecommendBook(String tag, int start, int count, JsonHttpResponseHandler jsonHandler)
	{
		HttpClient.get(tag, null, jsonHandler);
	}
	
	/**
	 * 图书列表（搜索图书结果）
	 * @param start
	 * @param count
	 */
	public static void getBookList(String q, int start, int count, JsonHttpResponseHandler jsonHandler)
	{
		RequestParams params = new RequestParams();
		
		try
		{
			params.put("q", q);
			params.put("start", String.valueOf(start));;
			params.put("count", String.valueOf(count));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		HttpClient.get("search", params, jsonHandler);
	}
}
