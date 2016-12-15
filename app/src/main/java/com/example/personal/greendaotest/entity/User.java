package com.example.personal.greendaotest.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by dell on 2016/12/15.
 */
@Entity
public class User  {

    @Id
    private long _id;

    private String name;
    private int age;
    private String phone;

    @Transient
    private String remark;
}
