package com.dao;

import java.util.List;

import com.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
@Repository
public interface UserDao {
    
    /* 获取前台用户输入的账号和密码跟数据库用户表进行判断*/
    User getUserByMassage(@Param("username") String username,@Param("password") String password);

    /* 获取用户数据以及设置分页 */
    List<User>getUserAll(@Param("username") String username,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    int getUserCounts(@Param("username")String username);

    int updateState(Integer id, Boolean state);

    int addUser(User user);

    User getUpdateUser(int id);
    
    int editUser(User user);
    
    int deleteUser(int id);
}
