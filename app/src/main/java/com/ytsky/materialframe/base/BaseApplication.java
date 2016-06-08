package com.ytsky.materialframe.base;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.ytsky.materialframe.service.LeakUploadService;
import com.ytsky.materialframe.utils.DateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/2 20:59
 * 描述：       程序的入口
 */
public class BaseApplication extends Application {

    /**
     * 全局Context，原理是因为Application类是应用最先运行的，所以在我们的代码调用时，该值已经被赋值过了
     */
    private static BaseApplication mInstance;
    /**
     * 主线程ID
     */
    private static int mMainThreadId;
    /**
     * 主线程ID
     */
    private static Thread mMainThread;
    /**
     * 主线程Handler
     */
    private static Handler mMainThreadHandler;
    /**
     * 主线程Looper
     */
    private static Looper mMainLooper;

    private RefWatcher mRefWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();

        //Fresco的注册
        Fresco.initialize(mInstance);
        //内在泄露检测
        mRefWatcher = LeakCanary.install(this, LeakUploadService.class);

        //捕捉未声明的异常
        mMainThread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
    }

    /**
     * 拿到内存泄露的观察对象
     * @return
     */
    public static RefWatcher getRefWatcher() {
        return mInstance.mRefWatcher;
    }

    /**
     * 捕获未声明的异常
     */
    private class MyUncaughtExceptionHandler implements
            Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {

            StringBuilder sb = new StringBuilder();
            //把时间给加上
            sb.append("\n\n\n");
            sb.append("------------------------------------------\n");
            sb.append("time:" + DateUtils.getTimeToString(System.currentTimeMillis()) + "\n");
            Field[] fields = Build.class.getDeclaredFields();
            sb.append("下面是设备信息：\n");
            for (Field field : fields) {
                try {
                    // 获得字段名
                    String fieldName = field.getName();
                    Object fieldValue = field.get(null);
                    sb.append(fieldName + "=" + fieldValue + "\n");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sb.append("\n本次的错误信息：\n");
            ex.printStackTrace();//输出到控制台
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);

            sb.append(sw);

            // 把异常信息写到一个sd卡上的文件中去
            try {
                File fl = new File(getFilesDir(), "error.txt");
                FileOutputStream out = new FileOutputStream(fl, true);

                out.write(sb.toString().getBytes());
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 自杀的方法,早死早超生(有些手机不支持...)
            android.os.Process.killProcess(android.os.Process.myPid());

        }
    }
}
