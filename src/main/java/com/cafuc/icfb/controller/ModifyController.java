package com.cafuc.icfb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ModifyController {
        @RequestMapping("/modifyfunc")
        public Integer UserRegister(
                @RequestParam("username") String username,
                @RequestParam("password") String password,//后略
                HttpServletRequest request
        ){
            return 0;
        };
        @RequestMapping("/modify")
        public ModelAndView UserModify(){
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }
        @RequestMapping("/modifyerror")
        public ModelAndView UserModifyError(){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("login", "用户名或密码错误");
            return modelAndView;
        }
    @RequestMapping("/modifysuccess")
    public ModelAndView UserModifySuccess(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}
