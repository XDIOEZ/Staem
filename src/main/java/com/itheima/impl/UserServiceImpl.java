package com.itheima.impl;

import com.itheima.entity.User;
import com.itheima.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.itheima.Dao.UserDao;

// 使用@Service注解将UserServiceImpl类标识为Spring中的Bean
@Service("userService")
public class UserServiceImpl implements UserService {

    // 使用@Resource注解注入UserDao
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void Save() {
        this.userDao.Save();
        System.out.println("执行UserServiceImpl.save()");
    }

    @Override
    public User login(User user) {
        return null;
    }

}