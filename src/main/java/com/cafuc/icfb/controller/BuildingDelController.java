package com.cafuc.icfb.controller;

import com.cafuc.icfb.service.BuildingService;
import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BuildingDelController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/deletebuilding")
    public Integer delBuilding(@RequestParam String buildname) {

        return buildingService.WorkoutService(buildname);
//        if(buildingService.WorkoutService(buildname)==1) {
//            ModelAndView modelAndView = new ModelAndView("center");
//            return modelAndView;
//        }
//        else{
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        }
    }


}
