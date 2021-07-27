package com.controller;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.entity.QueryInfo;
import com.entity.User;
import com.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        System.out.println(queryInfo);
        int numbers = userService.getUserCounts("%" + queryInfo.getQuery() + "%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = userService.getUserAll("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);
        System.out.println("总条数：" + numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
        int i = userService.updateState(id, state);
        System.out.println("用户编号:" + id);
        System.out.println("用户状态:" + state);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userService.addUser(user);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id) {
        System.out.println("编号:" + id);
        User updateUser = userService.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user) {
        System.out.println(user);
        int i = userService.editUser(user);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        System.out.println(id);
        int i = userService.deleteUser(id);
        String str = i > 0 ? "success" : "error";
        return str;
    }
}