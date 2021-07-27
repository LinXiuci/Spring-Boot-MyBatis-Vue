package com.service;


import java.util.List;

import com.dao.MainMenuDao;
import com.entity.MainMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainMenuService {
    
    @Autowired
    private MainMenuDao mainMenuDao;

    public List<MainMenu> getMainMenuAll(){
        return mainMenuDao.getMains();
    }
}
