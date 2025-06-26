package com.cafuc.icfb.controller;

import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.CData;
import com.cafuc.icfb.service.ActivityService;
import com.cafuc.icfb.service.CDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CDataListController {
    @Autowired
    CDataService cDataService;

    // 全部查询 分页
    @RequestMapping("/getcdatalist")
    public List<CData> activitieslist(@RequestParam int page, @RequestParam int pagesize){
        List<CData> getcdatalist = cDataService.CDataSearchService(page, pagesize);
        return getcdatalist;
    }
}
