package com.cafuc.icfb.controller;

import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
    @Autowired
    UserService userService;
    @RequestMapping("/logoutfunc")
    public String logout(HttpServletRequest request){
        if(userService.LogoutService(request)==1){
            return "login";
        }
        return "error";
    }
}
