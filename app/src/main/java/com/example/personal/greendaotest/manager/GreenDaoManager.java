package com.example.personal.greendaotest.manager;

import android.database.sqlite.SQLiteDatabase;

import com.example.personal.greendaotest.gen.DaoMaster;
import com.example.personal.greendaotest.gen.DaoSession;
import com.example.personal.greendaotest.utils.ConstantUtil;

/**
 * Created by dell on 2016/12/16.
 */
public class GreenDaoManager {

    private static GreenDaoManager mInstance = new GreenDaoManager();
    private DaoMaster mDaoMaster; //以一定的模式管理Dao类的数据库对象
    private DaoSession mDaoSession; //管理制定模式下的所有可用Dao对象
    private GreenDaoManager(){
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new
                    DaoMaster.DevOpenHelper(MyApplication.getmContext(), ConstantUtil.DBname, null);
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getmInstance(){
        return mInstance;
    }

    public DaoMaster getmDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        return mDaoSession = mDaoMaster.newSession();
    }

}
