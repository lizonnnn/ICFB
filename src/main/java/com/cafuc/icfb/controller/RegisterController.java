package com.cafuc.icfb.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @RequestMapping("/registerfunc")
    public Integer UserRegister(
            @RequestParam("username") String username,
            @RequestParam("password") String password,//后略
            HttpServletRequest request
    ){
        return 0;
    };
    @RequestMapping("/cancellationfunc")
    public Integer UserCancellation(
            @RequestParam("id") String id,
            HttpServletRequest request
    ){
        return 0;
    }

}
