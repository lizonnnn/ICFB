package com.cafuc.icfb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CenterController {
    @RequestMapping("/center")
    public ModelAndView cUserCenter(){
        ModelAndView modelAndView = new ModelAndView("center");
        return modelAndView;
    }
}
