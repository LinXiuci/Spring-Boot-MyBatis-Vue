package com.controller;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.entity.MainMenu;
import com.service.MainMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainMenuController {

    @Autowired
    private MainMenuService mainMenuService;

    @RequestMapping("/getmainmenuall")
    public String getMainMenuAll() {
        HashMap<String, Object> data = new HashMap<>();
        int status = 404;
        List<MainMenu> mainMenuList = mainMenuService.getMainMenuAll();
        if (mainMenuList != null) {
            data.put("menus", mainMenuList);
            data.put("flag", 200);
        } else {
            data.put("flag", 400);
        }
        String s = JSON.toJSONString(data);
        return s;
    }
}
