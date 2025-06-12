package com.cafuc.icfb.controller;

import com.cafuc.icfb.DAO.UserDao;
import com.cafuc.icfb.entity.User;
import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CancelControl {

    @Autowired
    private UserService userService;

    /**
     * 注销当前用户并重定向到登录页
     */
    @GetMapping("/cancel")
    public ModelAndView cancelUser(HttpSession session) {

        if(userService.WorkoutService(session)==1) {
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
}

