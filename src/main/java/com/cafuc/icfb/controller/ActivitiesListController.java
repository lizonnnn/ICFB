package com.cafuc.icfb.controller;

import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.service.ActivityService;
import com.cafuc.icfb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivitiesListController {
    @Autowired
    ActivityService activityService;

    // 全部查询 分页
    @RequestMapping("/getactivitieslist")
    public List<Activity> activitieslist(@RequestParam int page, @RequestParam int pagesize){
        List<Activity> getactivitiesList = activityService.ActivitiesSearchService(page, pagesize);
        return getactivitiesList;
    }

    // 查询对应活动的建筑
//    @RequestMapping("/activitiesbuildingnum")
//    public List<String> activitiesbuildingnum(@RequestParam String Acquisitionname){
//        return activityService.matchBuilding(Acquisitionname);
//    }
}
