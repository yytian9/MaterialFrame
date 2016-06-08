package com.ytsky.materialframe.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/2 20:38
 * 描述：
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //**********************************************start***这个是leakcanary观察内存泄露*******/
        RefWatcher refWatcher = BaseApplication.getRefWatcher();
        refWatcher.watch(this);
        //**********************************************end***这个是leakcanary观察内存泄露********/
    }
}
