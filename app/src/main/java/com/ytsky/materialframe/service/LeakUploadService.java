package com.ytsky.materialframe.service;

import android.util.Log;

import com.squareup.leakcanary.AnalysisResult;
import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.HeapDump;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 创建者：     yytian
 * 创建时间：   2016/4/15 15:39
 * 描述：	   这个服务接收内存泄露异常，写到文件中
 */
public class LeakUploadService extends DisplayLeakService {
    @Override
    protected void afterDefaultHandling(HeapDump heapDump, AnalysisResult result, String leakInfo) {
        if (!result.leakFound || result.excludedLeak) {
            return;
        }
        //可以上传到服务器中去，这里只写到文件中处理
        uploadLeakBlocking(heapDump.heapDumpFile, leakInfo);
    }

    /**
     * 把信息写到文件中去
     *
     * @param heapDumpFile
     * @param leakInfo
     */
    private void uploadLeakBlocking(File heapDumpFile, String leakInfo) {
        try {
            File fl = new File(getFilesDir(),"leakcanary_log.txt");
            Log.i("leakcanary",leakInfo);
            FileOutputStream out = new FileOutputStream(fl, true);
            out.write(leakInfo.toString().getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
