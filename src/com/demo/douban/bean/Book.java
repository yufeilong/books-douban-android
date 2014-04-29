package com.demo.douban.bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable
{

	private String mId = ""; // 图书id
	private String mTitle = ""; // 书名
	private Bitmap mCover; // 封面
	private String mAuthor = ""; // 作者
	private String mPublisher = ""; // 出版社
	private String mPublishDate = ""; // 出版时间
	private String mISBN = ""; // ISBN
	private String mSummary = ""; // 内容介绍
	private float mRating = 0; // 图书评分

	public Book(Parcel source)
	{
		// 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
		mId = source.readString();
		mTitle = source.readString();
		mCover = Bitmap.CREATOR.createFromParcel(source);
		mPublisher = source.readString();
		mPublishDate = source.readString();
		mISBN = source.readString();
		mSummary = source.readString();
		mRating = source.readFloat();
	}

	public String getmId()
	{
		return mId;
	}

	public void setmId(String mId)
	{
		this.mId = mId;
	}

	public String getmTitle()
	{
		return mTitle;
	}

	public void setmTitle(String mTitle)
	{
		this.mTitle = mTitle;
	}

	public Bitmap getmCover()
	{
		return mCover;
	}

	public void setmCover(Bitmap mCover)
	{
		this.mCover = mCover;
	}

	public String getmAuthor()
	{
		return mAuthor;
	}

	public void setmAuthor(String mAuthor)
	{
		this.mAuthor = mAuthor;
	}

	public String getmPublisher()
	{
		return mPublisher;
	}

	public void setmPublisher(String mPublisher)
	{
		this.mPublisher = mPublisher;
	}

	public String getmPublishDate()
	{
		return mPublishDate;
	}

	public void setmPublishDate(String mPublishDate)
	{
		this.mPublishDate = mPublishDate;
	}

	public String getmISBN()
	{
		return mISBN;
	}

	public void setmISBN(String mISBN)
	{
		this.mISBN = mISBN;
	}

	public String getmSummary()
	{
		return mSummary;
	}

	public void setmSummary(String mSummary)
	{
		this.mSummary = mSummary;
	}

	public float getmRating()
	{
		return mRating;
	}

	public void setmRating(float mRating)
	{
		this.mRating = mRating;
	}

	public static Book parse()
	{
		Book book = null;
		return book;
	}

	public final static Creator<Book> CREATOR = new Creator<Book>()
	{

		@Override
		public Book[] newArray(int size)
		{
			return new Book[size];
		}

		@Override
		public Book createFromParcel(Parcel source)
		{
			return new Book(source);
		}
	};

	@Override
	public int describeContents()
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		// 1.必须按成员变量声明的顺序封装数据，不然会出现获取数据出错
		// 2.序列化对象
		dest.writeString(mId);
		dest.writeString(mTitle);
		mCover.writeToParcel(dest, 0);
		dest.writeString(mAuthor);
		dest.writeString(mPublisher);
		dest.writeString(mPublishDate);
		dest.writeString(mISBN);
		dest.writeString(mSummary);
		dest.writeFloat(mRating);
	}
}
