package com.example.personal.greendaotest.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dell on 2016/12/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initListener();
        initData();
    }
    public abstract int getLayoutId();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();
}
