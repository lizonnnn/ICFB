package com.cafuc.icfb.controller;

import com.cafuc.icfb.DAO.UserDao;
import com.cafuc.icfb.entity.User;
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
        @Autowired
        UserDao userdao;
        @RequestMapping("/modifyfunc")
        public ModelAndView UserModifyfunc(
                @RequestParam("username") String username,
                @RequestParam("password") String password,//后略
                @RequestParam("email") String email,//后略
                HttpServletRequest request
        ){
            HttpSession session=request.getSession(false);
            Integer localuserid= (Integer) session.getAttribute("id");
            User user = userdao.getUserById();
            if(username ==""){
                username=user.getUsername();
            }
            if(password ==""){
                password=user.getPassword();
            }
            if(email ==""){
                email=user.getEmail();
            }
            if(userService.WorkoutService(session)==1){
                if(userService.RegisterService(username,password,email)==1) {
                    ModelAndView modelAndView = new ModelAndView("center");
                    userService.LoginService(username,password);
                    return modelAndView;
                }
            }
            else{
                ModelAndView modelAndView = new ModelAndView("center");
                return modelAndView;
            }
            ModelAndView modelAndView = new ModelAndView("center");
            return modelAndView;
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
            userService.LogoutService(request);
            ModelAndView modelAndView = new ModelAndView("login");

            return modelAndView;
        }
}
