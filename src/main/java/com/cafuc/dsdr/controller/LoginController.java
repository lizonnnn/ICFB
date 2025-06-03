package com.cafuc.dsdr.controller;

import com.cafuc.dsdr.DAO.UserDao;
import com.cafuc.dsdr.entity.User;
import com.cafuc.dsdr.service.UserService;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public ModelAndView cUserLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    @RequestMapping("/loginerror")
    public ModelAndView cUserLoginError(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login", "用户名或密码错误");
        return modelAndView;
    }
    @RequestMapping("/getusername")
    @ResponseBody
    public String getUsername(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        return session.getAttribute("username").toString();
    }
    @RequestMapping("/loginfunc")
    public String UserLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request
    ){
        HttpSession session=request.getSession(true);
        String user=userService.getUserByUaP(username,password);

        if(user!=null){
            session.setAttribute("username", user);
            return "ip";
        }
        else{
            return "loginerror";
        }
    }
}
