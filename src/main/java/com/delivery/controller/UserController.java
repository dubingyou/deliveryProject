package com.delivery.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.delivery.entity.User;
import com.delivery.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yvan
 * @Description 用户控制层
 * @Classname UserController
 * @Date 2020/10/18 18:35
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/save")
    @ResponseBody
    public String saveUser(User user){
        user = userService.saveUser(user);
        return JSONObject.toJSONString(user);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String findUser(){
        PageInfo<User> userAll = userService.findUserAll();
        return JSON.toJSONString(userAll);
    }

}
