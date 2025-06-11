package com.cafuc.icfb.service;

import com.cafuc.icfb.DAO.UserDao;
import com.cafuc.icfb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User LoginService(String username,String password) {
        List<User> userlist = userDao.getUserByUaP(username, password);
        if (!userlist.isEmpty()) {

            return userlist.get(0);
        } else
            return null;
    }
    // 注册服务：注册成功返回1，用户名已存在返回0
    public Integer RegisterService(String username, String password, String email) {
        // 查重（看用户名是否已存在）
        List<User> userList = userDao.getUserList();
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return 0; // 用户名已存在
            }
        }
        return userDao.addUser(username, password, email); // 插入成功返回 1
    }
    public Integer LogoutService(Integer id ) {//登出
        return 0;
    }
    public Integer WorkoutService(Integer id) {//注销
        return 0;
    }



}
