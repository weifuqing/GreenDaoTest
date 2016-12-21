package com.example.personal.greendaotest.utils;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import com.example.personal.greendaotest.manager.MyApplication;
import java.io.File;

/**
 * Created by dell on 2016/7/25.
 */
public class FileUtil {

    public static final File SDCARD = new File(Environment.getExternalStorageDirectory(),
            MyApplication.getApplicationName());
    public static final File PICTURE = new File(SDCARD,"picture");
    public static final File EXCEL = new File(SDCARD,"excel");


    //发布更新
    public static void sendBroadcast(Context context,File file){
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

}
