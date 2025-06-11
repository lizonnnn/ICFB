package com.cafuc.icfb.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
    @PostMapping("/logoutfunc")
    public String logout(HttpServletRequest request) {

        // 1. 获取当前 Session（如果存在）
        HttpSession session = request.getSession(false);

        // 2. 销毁 Session（如果存在）
        if (session != null) {
            session.invalidate();// 清除所有 Session 数据
        }

        // 3. 重定向到登录页（login.html）
        return "login";// 重定向到登录页（login.html）
    }
}
