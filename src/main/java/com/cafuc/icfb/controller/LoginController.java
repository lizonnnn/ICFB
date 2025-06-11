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
public class LoginController {
    @Autowired
    UserService userService;
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
        if(session==null)
        {
            return "";
        }
        return session.getAttribute("username").toString();
    }
    @RequestMapping("/loginfunc")
    public String UserLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request
    ){
        HttpSession session=request.getSession(true);
        User localuser=userService.LoginService(username,password);
        if(localuser!=null){
            String localusername= localuser.getUsername();
            Integer localid=localuser.getId();
            System.out.println(localuser.toString());
            session.setAttribute("username", localusername);
            session.setAttribute("id", localid);
            return "center";//这里应是正常功能界面，error暂代
        }
        else{
            return "loginerror";
        }
    }
}
