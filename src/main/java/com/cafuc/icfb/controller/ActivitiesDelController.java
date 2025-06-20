package com.cafuc.icfb.controller;

import com.cafuc.icfb.service.ActivityService;
import com.cafuc.icfb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ActivitiesDelController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/deleteactivity")
    public Integer delactivity(@RequestParam String Acquisitionname) {
        return activityService.WorkoutService(Acquisitionname);
    }
}
