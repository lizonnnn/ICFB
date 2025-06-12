package com.cafuc.icfb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgetController {
    @RequestMapping("/forgetfunc")
    public Integer UserRegister(
            @RequestParam("username") String username,
            @RequestParam("password") String password,//后略
            HttpServletRequest request
    ){
        return 0;
    };
    @RequestMapping("/forget")
    public ModelAndView UserLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    @RequestMapping("/forgeterror")
    public ModelAndView cUserLoginError(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login", "用户名或密码错误");
        return modelAndView;
    }


}
