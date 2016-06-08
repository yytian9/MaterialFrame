package com.ytsky.materialframe.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.leakcanary.RefWatcher;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/2 20:39
 * 描述：
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //**********************************************start***这个是leakcanary观察内存泄露*******/
        RefWatcher refWatcher = BaseApplication.getRefWatcher();
        refWatcher.watch(this);
        //**********************************************end***这个是leakcanary观察内存泄露********/
    }
}
