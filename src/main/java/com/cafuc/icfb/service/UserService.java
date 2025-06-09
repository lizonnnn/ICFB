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
    public Integer RegisterService(String username,String password) {
        return 0;
    }
    public Integer LogoutService(String username,String password) {//登出
        return 0;
    }
    public Integer WorkoutService(String username,String password) {//注销
        return 0;
    }



}
