package com.cafuc.dsdr.controller;

import com.cafuc.dsdr.entity.User;
import com.cafuc.dsdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController
{
    @RequestMapping({"/index","/"})
    public String Index(){
        return "login";
    }
}
