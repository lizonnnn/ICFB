package com.cafuc.icfb.controller;

import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.service.BuildingService;
import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingSearchController {
    @Autowired
    BuildingService buildingService;
    @RequestMapping("/buildingsearch")

    public List<Building> BuildingSearch(@RequestParam int page, @RequestParam int pagesize){
        List<Building> buildingList = buildingService.BuildingSearchService(page, pagesize);
        return buildingList;
    }

}
