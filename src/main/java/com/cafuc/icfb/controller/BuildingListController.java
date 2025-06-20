package com.cafuc.icfb.controller;

import com.cafuc.icfb.DAO.BuildingDao;
import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingListController {
    @Autowired
    BuildingService buildingService;
    @Autowired
    BuildingDao buildingDao;

    // 全部查询 分页
    public List<Building> BuildingList(@RequestParam int page, @RequestParam int pagesize){
        List<Building> buildingList = buildingService.BuildingListService(page, pagesize);
        return buildingList;
    }

    // 全部查询返回页数
    @RequestMapping("/buildingnum")
    public Integer GetPageNum(@RequestParam int pagesize){
        return buildingService.CountNumService(pagesize);
    }

    // 模糊查询 分页
    @RequestMapping("/buildingsearchfuzzy")
    public List<Building> BuildingSearchfuzzy(@RequestParam int page, @RequestParam int pagesize, @RequestParam String fuzzystr){
        List<Building> buildingList = buildingService.BuildingSearchServicefuzzy(page, pagesize, fuzzystr);
        return buildingList;
    }

    // 模糊查询返回页数
    @RequestMapping("/buildingnumcountfuzzy")
    public Integer GetPageNumFuzzy(@RequestParam int pagesize, @RequestParam String buildingname){
        return buildingService.CountNumServiceFuzz(pagesize, buildingname);
    }

    // 查询对应建筑的活动
    @RequestMapping("/activitiesbuildingnum")
    public List<Activity> activitiesbuildingnum(@RequestParam String buildingname){
        return buildingService.matchActivity(buildingname);
    }

}
