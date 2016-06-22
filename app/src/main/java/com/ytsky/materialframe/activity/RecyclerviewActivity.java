package com.ytsky.materialframe.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ytsky.materialframe.R;
import com.ytsky.materialframe.adapter.MyTestAdapter;
import com.ytsky.materialframe.base.BaseActivity;
import com.ytsky.materialframe.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity {

    private LinearLayoutManager mLinearLayoutManager;
    private MyTestAdapter mAdapter;
    private boolean isLoading = false;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mAdapter.addData(getData());
            isLoading = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_test);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new MyTestAdapter(this, getData());
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Toast.makeText(RecyclerViewActivity.this, "点击了……", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();
                int itemCount = mLinearLayoutManager.getItemCount();
                if (itemCount - 2 > lastVisibleItemPosition) {
                    if (!isLoading) {
                        new Thread() {
                            @Override
                            public void run() {
                                isLoading = true;
                                SystemClock.sleep(5000);
                                mHandler.sendEmptyMessage(0);
                            }
                        }.start();
                    }

                }

            }
        });
    }

    public List<Integer> getData() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        return list;
    }
}
