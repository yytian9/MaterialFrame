package com.ytsky.materialframe.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ytsky.materialframe.R;
import com.ytsky.materialframe.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {

    }
    private void initData() {

    }
    private void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recyclerview_test:
                startActivity(new Intent(this,RecyclerViewActivity.class));
                break;

            default:
                break;
        }
    }

    /*static class MainFragmentStatePagerAdaper extends FragmentStatePagerAdapter {
        public MainFragmentStatePagerAdaper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            if (mMainTitleArr != null) {
                return mMainTitleArr.length;
            }
            return 0;
        }

        @Override
        public Fragment getItem(int position) {

            Log.i(TAG, "初始化了" + mMainTitleArr[position]);

            // 需要我们返回一个一个的fragment
            // 工厂
            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        *//**
         * 必须覆写getPageTitle
         *//*
        @Override
        public CharSequence getPageTitle(int position) {

            return mMainTitleArr[position];
        }
    }*/
}
