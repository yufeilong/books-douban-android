package com.demo.douban.bean;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/4/30.
 */
public class BookList implements Parcelable {

    private int mTotal;
    private int mCount;
    private List<Book> mBookList = new ArrayList<Book>();

    public int getmTotal() {
        return mTotal;
    }

    public void setmTotal(int mTotal) {
        this.mTotal = mTotal;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public List<Book> getmBookList() {
        return mBookList;
    }

    public void setmBookList(List<Book> mBookList) {
        this.mBookList = mBookList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCount);
        dest.writeInt(mTotal);
        dest.writeList(mBookList);
    }

    public final static Creator<BookList> CREATOR = new Creator<BookList>() {
        @Override
        public BookList createFromParcel(Parcel source) {
            BookList bookList = new BookList();
            bookList.setmCount(source.readInt());
            bookList.setmTotal(source.readInt());
            bookList.setmBookList(source.readArrayList(BookList.class.getClassLoader()));

            return bookList;
        }

        @Override
        public BookList[] newArray(int size) {
            return new BookList[0];
        }
    };

    public static BookList parse(JSONObject jsonObject) {
        BookList bookList = new BookList();
        Book book = null;

        if ((jsonObject!=null) && (jsonObject.length()!=0)) {
            try {
                bookList.mCount = jsonObject.getInt("count");
                bookList.mTotal = jsonObject.getInt("total");
                JSONArray bookArray = jsonObject.getJSONArray("books");
                if (bookArray.length()!=0) {
                    for (int i=0; i <bookArray.length(); i++) {
                        book = new Book();
                        JSONObject bookJson = bookArray.getJSONObject(i);
                        book.setmTitle(bookJson.getString("title"));
                        book.setmSummary(bookJson.getString("summary"));
                        book.setmPublishDate(bookJson.getString("pubdate"));
                        book.setmPublisher(bookJson.getString("publisher"));
                        book.setmISBN(bookJson.getString("isbn13"));

                        bookList.getmBookList().add(book);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return bookList;
    }
}
