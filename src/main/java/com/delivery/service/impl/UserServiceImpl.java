package com.delivery.service.impl;

import com.delivery.dao.UserDao;
import com.delivery.entity.User;
import com.delivery.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yvan
 * @Description
 * @Classname UserServiceImpl
 * @Date 2020/10/18 18:34
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public PageInfo<User> findUserAll() {
        PageHelper.startPage(1,3);
        List<User> userList = userDao.selectUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
