package com.example.personal.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.personal.greendaotest.base.BaseActivity;
import com.example.personal.greendaotest.base.BasicAdapter;
import com.example.personal.greendaotest.base.ViewHolder;
import com.example.personal.greendaotest.entity.User;
import com.example.personal.greendaotest.gen.UserDao;
import com.example.personal.greendaotest.manager.GreenDaoManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {


    @BindView(R.id.lv_user)
    ListView lv_user;

    Unbinder unbinder;
    UserDao userDao;
    List<User> users;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        userDao = GreenDaoManager.getmInstance().getmDaoSession().getUserDao();
        userDao.deleteAll();
        userDao.insert(new User(1, "周一", 24, "1382382334"));
        userDao.insert(new User(4, "周四", 24, "1382382334"));
        userDao.insert(new User(2, "周二", 24, "1382382334"));
        userDao.insert(new User(3, "周三", 24, "1382382334"));
        userDao.insert(new User(5, "周五", 24, "1382382334"));

//        userDao.insert(new User());
//        userDao.insert(new User());
//        userDao.insert(new User());
//        userDao.insert(new User());
//        userDao.insert(new User());
        users = userDao.queryBuilder().list();
        lv_user.setAdapter(new BasicAdapter<User>(MainActivity.this, users, R.layout.item_user) {
            @Override
            public void onBindHolder(ViewHolder holder, User item, int position) {
                holder.setText(R.id.tv_userinfo, item.getId() + "***" +
                        item.getName() + "***" + item.getAge() + "***" + item.getPhone());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
