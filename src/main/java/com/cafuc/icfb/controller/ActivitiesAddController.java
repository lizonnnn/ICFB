package com.cafuc.icfb.controller;

import com.cafuc.icfb.service.ActivityService;
import com.cafuc.icfb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ActivitiesAddController {
    @Autowired
    ActivityService activityService;

    @RequestMapping("/addactivity")
    public Integer activityadd(
            @RequestParam("buildingId") Integer buildingid,
            @RequestParam("Acquisitionname") String Acquisitionname,
            @RequestParam("time") String time) {

            return activityService.addactivity(buildingid,Acquisitionname,time);
    }
}
