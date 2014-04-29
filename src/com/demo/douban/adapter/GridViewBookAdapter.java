package com.demo.douban.adapter;

import java.util.List;

import com.demo.douban.R;
import com.demo.douban.bean.Book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewBookAdapter extends BaseAdapter
{
	private Context context;
	private List<Book> listItems;
	private LayoutInflater listContainer;
	private int itemViewResource;
	
	static class ListItemView
	{
        public TextView title;
        public TextView author;
	    public TextView date;  
	    public TextView rating;
	    public TextView sumarry;
	    public ImageView cover;
	}
	
	public GridViewBookAdapter(Context context, List<Book> data, int resource)
	{
		this.context = context;
		this.listContainer = LayoutInflater.from(context);
		this.listItems = data;
		this.itemViewResource = resource;
	}

	@Override
	public int getCount() 
	{
		return listItems.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return null;
	}

	@Override
	public long getItemId(int position) 
	{
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ListItemView listItemView = null;
		
		if (convertView == null) 
		{
			//获取list_item布局文件的视图
			convertView = listContainer.inflate(this.itemViewResource, null);
			
			listItemView = new ListItemView();
			//获取控件对象
			listItemView.title = (TextView)convertView.findViewById(R.id.find_book_title);
			listItemView.author = (TextView)convertView.findViewById(R.id.find_book_autor);
			listItemView.date = (TextView)convertView.findViewById(R.id.find_book_date);
			listItemView.sumarry = (TextView)convertView.findViewById(R.id.find_book_summary); 
			listItemView.cover = (ImageView)convertView.findViewById(R.id.find_book_image);
			//设置控件集到convertView
			convertView.setTag(listItemView);
		}
		else 
		{
			listItemView = (ListItemView)convertView.getTag();
		}
		
		//设置文字和图片
		Book book = listItems.get(position);
		listItemView.title.setText(book.getmTitle());
		listItemView.author.setText(book.getmAuthor());
		listItemView.date.setText(book.getmPublishDate());
		listItemView.sumarry.setText(book.getmSummary());
		listItemView.cover.setImageBitmap(book.getmCover());
		
		return null;
	}

}
