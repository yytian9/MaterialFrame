package com.ytsky.materialframe.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.ytsky.materialframe.base.BaseApplication;


/**
 * 创建者：     yytian
 * 创建时间：   2016/6/22 20:41
 * 描述：      吐司的相关处理
 */
public class ToastUtils {

    public static void openToast(int resId) {
        Toast.makeText(BaseApplication.getApplication(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void openToast(String msg) {
        Toast.makeText(BaseApplication.getApplication(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void openCenterToast(int resId) {
        Toast toast = Toast.makeText(BaseApplication.getApplication(), resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public static void openCenterToast(String msg) {
        Toast toast = Toast.makeText(BaseApplication.getApplication(), msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
