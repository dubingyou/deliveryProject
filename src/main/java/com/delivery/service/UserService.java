package com.delivery.service;

import com.delivery.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Yvan
 * @Description user service 接口
 * @Classname UserService
 * @Date 2020/10/18 18:31
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @param user user
     * @return user
     */
    User saveUser(User user);

    /**
     * 修改用户
     *
     * @param user user
     * @return true
     */
    boolean updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return 集合
     */
    PageInfo<User> findUserAll();
}
