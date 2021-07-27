package com.controller;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录判断
     */
    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        String flag = "error";
        User loginUser = userService.getUserByMassage(user.getUsername(), user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (loginUser != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", user);
        String res_json = JSON.toJSONString(res);
        System.out.println(loginUser);
        return res_json;
    }
}
