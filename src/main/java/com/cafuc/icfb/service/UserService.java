package com.cafuc.icfb.service;

import com.cafuc.icfb.DAO.UserDao;
import com.cafuc.icfb.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    public Integer WorkoutService(HttpSession session) {
        // 从session中获取用户
        Integer localid = (Integer) session.getAttribute("id");
        if (localid != null) {
            // 删除数据库中的用户（根据ID）
            session.invalidate();
            return userDao.deleteUserById(localid);
        }
        return 0;
    }

    public Integer LogoutService(HttpServletRequest request) {
        // 1. 获取当前 Session（如果存在）
        HttpSession session = request.getSession(false);
        // 2. 销毁 Session（如果存在）
        if (session != null) {
            session.invalidate();// 清除所有 Session 数据
            return 1;
        }
        // 3. 重定向到登录页（login.ftl）
        return 0;// 重定向到登录页（login.ftl）
    }

}
