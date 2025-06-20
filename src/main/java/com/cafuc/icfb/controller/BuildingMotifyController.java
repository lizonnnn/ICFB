package com.cafuc.icfb.controller;

import com.cafuc.icfb.DAO.BuildingDao;
import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingMotifyController {
    @Autowired
    BuildingService buildingService;
    @RequestMapping("/modifybuilding")
    public Integer BuildingModify(@RequestParam("buildname") String buildname,
                                  @RequestParam("introduction") String introduction) {

        return buildingService.BuildingModifyService(buildname,introduction);
    }
}
