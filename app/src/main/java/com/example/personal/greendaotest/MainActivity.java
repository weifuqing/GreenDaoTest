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
import com.example.personal.greendaotest.utils.ExcelUtil;
import com.example.personal.greendaotest.utils.FileUtil;

import java.io.File;
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
        userDao.insert(new User(null, "周一", 24, "1382382334"));
        userDao.insert(new User(null, "周四", 24, "1382382334"));
        userDao.insert(new User(null, "周二", 24, "1382382334"));
        userDao.insert(new User(null, "周三", 24, "1382382334"));
        userDao.insert(new User(null, "周五", 24, "1382382334"));

        users = userDao.queryBuilder().list();
        lv_user.setAdapter(new BasicAdapter<User>(MainActivity.this, users, R.layout.item_user) {
            @Override
            public void onBindHolder(ViewHolder holder, User item, int position) {
                holder.setText(R.id.tv_userinfo, item.getId() + "***" +
                        item.getName() + "***" + item.getAge() + "***" + item.getPhone());
            }
        });
        saveAsExcel();
    }

    private void saveAsExcel(){
        File file = new File(FileUtil.EXCEL,"user.xls");
        String[] title = new String[]{
                "ID",
                "名字",
                "年龄",
                "电话"
        };
        ExcelUtil.initExcel(file.getAbsolutePath(),title);
        ExcelUtil.writeUserToExcel(users,file.getAbsolutePath(),this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
