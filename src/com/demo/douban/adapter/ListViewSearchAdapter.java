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

public class ListViewSearchAdapter extends BaseAdapter
{
	private Context context;				//运行上下文
	private List<Book> listItems;			//数据集合
	private LayoutInflater listContainer;	//视图容器
	private int itemViewResource;			//自定义项视图源 
	
	static class ListItemView
	{  
	        public TextView title;
	        public TextView author;
		    public TextView date;
		    public TextView publisher;
		    public TextView rating;
		    public ImageView conver;
	}
	
	public ListViewSearchAdapter(Context context, List<Book> data, int resource)
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
		ListItemView  listItemView = null;
		
		if (convertView == null) 
		{
			/* 获取list_item布局文件的视图 */
			convertView = listContainer.inflate(this.itemViewResource, null);
			listItemView = new ListItemView();
			
			/* 获取控件对象 */
			listItemView.title = (TextView)convertView.findViewById(R.id.book_listitem_title);
			listItemView.author = (TextView)convertView.findViewById(R.id.book_listitem_autor);
			listItemView.date = (TextView)convertView.findViewById(R.id.book_listitem_date);
			listItemView.publisher = (TextView)convertView.findViewById(R.id.book_listitem_publisher);
			listItemView.rating = (TextView)convertView.findViewById(R.id.book_listitem_rating);
			listItemView.conver = (ImageView)convertView.findViewById(R.id.book_listitem_cover);
			
			/* 设置控件集到convertView */
			convertView.setTag(listItemView);
		}
		else
		{
			listItemView = (ListItemView)convertView.getTag();
		}
		
		/* 设置文字和图片 */
		Book book = listItems.get(position);
		listItemView.title.setText(book.getmTitle());
		listItemView.author.setText(book.getmAuthor());
		listItemView.date.setText(book.getmPublishDate());
		listItemView.publisher.setText(book.getmPublisher());
		listItemView.rating.setText(Float.toString(book.getmRating()));
		listItemView.conver.setImageResource(R.drawable.ic_action_refresh);
		
		return convertView;
	}

}
