package com.cafuc.icfb.controller;

import com.cafuc.icfb.service.BuildingService;
import com.cafuc.icfb.service.CDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CDataDelController {

    @Autowired
    private CDataService cDataService;

    @GetMapping("/deletecData")
    public int delCData(@RequestParam int internalnumber) {
        return cDataService.WorkoutService(internalnumber);
//        if (cDataService.WorkoutService(url) == 1) {
//            ModelAndView modelAndView = new ModelAndView("center");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        }
    }
}
