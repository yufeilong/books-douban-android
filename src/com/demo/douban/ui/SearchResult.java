package com.demo.douban.ui;

import java.util.ArrayList;
import java.util.List;

import com.demo.douban.R;
import com.demo.douban.adapter.ListViewBookAdapter;
import com.demo.douban.bean.Book;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SearchResult extends Activity 
{
	private ListViewBookAdapter lvBookAdapter;
	
	private List<Book> lvBookData = new ArrayList<Book>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActionBar actionBar = this.getActionBar();  
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		initBookListView();
		initBookListData();
	}
	
	private void initBookListView()
	{
		lvBookAdapter = new ListViewBookAdapter(this, lvBookData, R.layout.search_list_item);
	}
	
	private void initBookListData()
	{
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.search_result, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
	    {
	        case R.id.action_refresh:
	        {
	        	Toast.makeText(getApplicationContext(), "refresh", Toast.LENGTH_SHORT).show();  
	        	return true;	        	
	        }
	        case android.R.id.home:
	        {
	        	finish();
	        }
	        default:
	        {
	            return super.onOptionsItemSelected(item);
	        }
	    }
	}
	
	
}
