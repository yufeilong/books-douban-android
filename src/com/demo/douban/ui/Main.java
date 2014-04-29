package com.demo.douban.ui;

import com.demo.douban.R;
import com.demo.douban.api.ApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

/**
 * 应用程序首页
 * @author yufeilong
 */
public class Main extends Activity
{
	private JsonHttpResponseHandler  recommendHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		this.initView();
		//this.loadData(tag, start, count);
	}
	
	/**
	 * 创建	actionbar item
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		searchView.setQueryHint(getResources().getString(R.string.action_search_hint));
		
		searchView.setOnQueryTextListener(new OnQueryTextListener() 
		{
			@Override
			public boolean onQueryTextSubmit(String q) 
			{
				InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
				
				loadData(q, 0, 5);;
				
				Intent intent = new Intent(Main.this, SearchResult.class);
				startActivity(intent);
				
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) 
			{
				if (newText.length() > 0) 
				{	
				}
				else
				{	
				}
				return false;
			}
		});
		
	    return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * 监听actionbar上item被选中后的事件
	 * @param item
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
	    {
	        case R.id.action_search:
	        {
	        	//openSearch();
	        	Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();  
	        	return true;	        	
	        }
	        case R.id.action_labels:
	        {
	            //composeMessage();
	        	Toast.makeText(getApplicationContext(), "labels", Toast.LENGTH_SHORT).show();
	        	Intent intent = new Intent(this, Tags.class);
	        	startActivity(intent);
	            return true;
	        }
	        default:
	        {
	            return super.onOptionsItemSelected(item);
	        }
	    }
	}
	
	private void initView()
	{
		/* 创建actionbar */
		ActionBar actionBar = this.getActionBar();  
		actionBar.setDisplayHomeAsUpEnabled(false);  
	}
	
	private void loadData(String tag, int start, int count)
	{
		ApiClient.getRecommendBook(tag, start, count, recommendHandler);
	}
	
	/**
	 * 监听返回--是否退出程序
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		return false;
	}
}
