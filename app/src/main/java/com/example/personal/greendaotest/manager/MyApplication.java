package com.example.personal.greendaotest.manager;

import android.app.Application;
import android.content.Context;

/**
 * Created by dell on 2016/12/16.
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        //GreenDao全局配置
        GreenDaoManager.getmInstance();
    }

    public static Context getmContext(){
        return mContext;
    }
}
