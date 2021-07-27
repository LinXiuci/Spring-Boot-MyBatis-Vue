package com.dao;

import java.util.List;

import com.entity.MainMenu;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMenuDao {
    
    List<MainMenu>getMains();
}
