package com.ytsky.materialframe.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


/**
 * 创建者：     yytian
 * 创建时间：   2016/5/2 20:41
 * 描述：      吐司的相关处理
 */
public class ToastUtils {

    public static void openToast(Context context, int resId) {
        if (context != null) {
            Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
        }
    }

    public static void openToast(Context context, String msg) {
        if (context != null && msg != null) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void openCenterToast(Context context, int resId) {
        if (context != null) {
            Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

}
