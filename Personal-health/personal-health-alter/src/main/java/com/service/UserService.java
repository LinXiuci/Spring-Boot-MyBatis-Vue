package com.service;

import java.util.List;

import com.dao.UserDao;
import com.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByMassage(@Param("username") String username, @Param("password") String password) {
        return userDao.getUserByMassage(username, password);
    }

    public List<User> getUserAll(@Param("username") String username, @Param("pageStart") int pageStart,
            @Param("pageSize") int pageSize) {
        return userDao.getUserAll(username, pageStart, pageSize);
    }

    public int getUserCounts(@Param("username") String username) {
        return userDao.getUserCounts(username);
    }

    public int updateState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
        return userDao.updateState(id, state);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public User getUpdateUser(int id) {
        return userDao.getUpdateUser(id);
    }

    public int editUser(User user) {
        return userDao.editUser(user);
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

}
