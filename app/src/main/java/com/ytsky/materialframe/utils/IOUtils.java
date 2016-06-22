package com.ytsky.materialframe.utils;

import android.util.Log;

import java.io.Closeable;
import java.io.IOException;
/**
 * 创建者：     yytian
 * 创建时间：   2016/5/2 20:41
 * 描述：		io流的相关处理方法
 */
public class IOUtils {
	/** 关闭流 */
	public static boolean close(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (IOException e) {
				Log.e("IoUtils",e.toString());
			}
		}
		return true;
	}
}
