package com.example.personal.greendaotest.manager;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.personal.greendaotest.utils.FileUtil;

/**
 * Created by dell on 2016/12/16.
 */
public class MyApplication extends Application {

    private static Context mContext;
    private static final String APPLICATION_NAME = "GreenDaoTest";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        //文件夹初始化
        if(!FileUtil.SDCARD.exists()){
            FileUtil.SDCARD.mkdirs();
        }
        if(!FileUtil.PICTURE.exists()){
            FileUtil.PICTURE.mkdirs();
        }
        if(!FileUtil.EXCEL.exists()){
            FileUtil.EXCEL.mkdirs();
        }

        //GreenDao全局配置
        GreenDaoManager.getmInstance();
    }

    public static Context getmContext(){
        return mContext;
    }

    public static String getApplicationName(){

        return APPLICATION_NAME;
    }
}
