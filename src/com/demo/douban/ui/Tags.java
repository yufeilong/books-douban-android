package com.demo.douban.ui;


import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class Tags extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActionBar actionBar = this.getActionBar();  
        actionBar.setDisplayHomeAsUpEnabled(true);
        
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
	    {
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
