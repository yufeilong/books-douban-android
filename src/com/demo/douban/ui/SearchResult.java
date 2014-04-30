package com.demo.douban.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Message;
import com.demo.douban.R;
import com.demo.douban.adapter.ListViewBookAdapter;
import com.demo.douban.api.ApiClient;
import com.demo.douban.bean.Book;

import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.demo.douban.bean.BookList;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONObject;

public class SearchResult extends Activity {
    private ListViewBookAdapter lvBookAdapter;

    private List<Book> lvBookData = new ArrayList<Book>();

    String q = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        q = bundle.getString("q");

        initBookListView();
        initBookListData();
    }

    private void initBookListView() {
        lvBookAdapter = new ListViewBookAdapter(this, lvBookData, R.layout.search_list_item);
    }

    private void initBookListData() {
        ApiClient.getBookList(q, 0, 2, new JsonHttpResponseHandler() {
            @Override
            public void onFinish() {
                super.onFinish();
            }

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onFailure(Throwable throwable, JSONObject jsonObject) {
                super.onFailure(throwable, jsonObject);
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                super.onSuccess(jsonObject);

                if (lvBookData.size()!=0) {
                    lvBookData.clear();
                }

                lvBookData.addAll(BookList.parse(jsonObject).getmBookList());

                mHandler.sendEmptyMessage(9998);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_result, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh: {
                Toast.makeText(getApplicationContext(), "refresh", Toast.LENGTH_SHORT).show();
                return true;
            }
            case android.R.id.home: {
                finish();
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 9998) {

            }
        }
    };


}
