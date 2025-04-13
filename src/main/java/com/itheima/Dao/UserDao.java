package com.itheima.Dao;

import com.itheima.entity.User;

public interface UserDao {

    // 通过User的用户账号和用户密码查询用户信息
    User login(User user);

    public void Save();
}
