package com.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主导航
 *   
 * */ 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainMenu {
    private Integer id;
    private String title;
    private String path;
    private List<SubMenu>subMenuslList;
}
