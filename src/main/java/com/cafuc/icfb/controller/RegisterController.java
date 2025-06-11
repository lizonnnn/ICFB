package com.cafuc.icfb.controller;

import com.cafuc.icfb.entity.User;
import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/registerfunc")
    public ModelAndView registerFunc(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {

        Integer result = userService.RegisterService(username, password, email);

        if (result == 1) {
            return new ModelAndView("login");
        } else {
            ModelAndView mv = new ModelAndView("register");
            mv.addObject("error", "用户名已存在！");
            return mv;
        }
    }
}

