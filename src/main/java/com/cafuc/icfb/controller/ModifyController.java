package com.cafuc.icfb.controller;

import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ModifyController {
    @Autowired
    UserService userService;
        @RequestMapping("/modifyfunc")
        public Integer UserModifyfunc(
                @RequestParam("username") String username,
                @RequestParam("password") String password,//后略
                @RequestParam("email") String email,//后略
                HttpServletRequest request
        ){
            HttpSession session=request.getSession(false);
            Integer localuserid= Integer.parseInt((String) session.getAttribute("id"));
            userService.LogoutService(localuserid);
            userService.WorkoutService(localuserid);
            return userService.RegisterService(username,password,email);
        };
        @RequestMapping("/modify")
        public ModelAndView UserModify(){
            ModelAndView modelAndView = new ModelAndView("modify");
            return modelAndView;
        }
        @RequestMapping("/modifysuccess")
        public ModelAndView UserModifySuccess(HttpServletRequest request){
            HttpSession session=request.getSession(false);
            Integer localuserid= Integer.parseInt((String) session.getAttribute("id"));
            userService.LogoutService(localuserid);
            ModelAndView modelAndView = new ModelAndView("login");

            return modelAndView;
        }
}
