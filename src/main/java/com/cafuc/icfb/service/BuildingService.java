package com.cafuc.icfb.service;

import com.cafuc.icfb.DAO.ActivityDao;
import com.cafuc.icfb.DAO.BuildingDao;
import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.Building;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BuildingService {
    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private ActivityDao activityDao;

    public List<Building> BuildingListService(int page,int pagesize) {
        if(page>=1){
            List<Building> buildingList = buildingDao.getBuildingList(pagesize,(page-1)*pagesize);
            return buildingList;
        }
        else
            return null;
    }
    public Integer BuildingModifyService(String buildname,String introduction) {

        List<Building> buildinglist=buildingDao.getBuildingByName(buildname);
        Building building;
        if(buildinglist.isEmpty())
        {
            return 0;
        }
        else{
            building=buildinglist.get(0);
        }
        if(Objects.equals(buildname,"")){
            buildname=building.getBuildName();
        }
        if(Objects.equals(introduction, "")){
            introduction=building.getIntroduction();
        }
        if(buildingDao.deleteBuilding(buildname)==1)
        {
            if(buildingDao.addBuilding(buildname,introduction)==1)
                return 1;
        }
        return 0;
    }
    public Integer addBuilding(String buildname,String introduction) {
        List<Building> buildingList = buildingDao.getBuildingListAll();
        for (Building u : buildingList) {
            if (u.getBuildName().equals(buildname)) {
                return 0;
            }
        }
        return buildingDao.addBuilding(buildname, introduction); // 插入成功返回 1
    }

    public Integer WorkoutService(String buildname) {
        return buildingDao.deleteBuilding(buildname);
    }

    public List<Building> BuildingSearchServicefuzzy(int page,int pagesize, String buildName) {
        if(page>=1){
            List<Building> buildingList = buildingDao.getBuildingListfuzzy(pagesize,(page-1)*pagesize, buildName);
            return buildingList;
        }
        else
            return null;
    }

    public Integer CountNumService(int pagesize) {
        List<Building> buildingList = buildingDao.getBuildingListAll();
        return (int) Math.ceil((double) buildingList.size() / pagesize);
    }

    public Integer CountNumServiceFuzz(int pagesize, String buildName) {
        List<Building> buildingList = buildingDao.fuzzySearchByName(buildName);
        return (int) Math.ceil((double) buildingList.size() / pagesize);
    }

    public List<Activity> matchActivity(String buildingname) {
        List<Building> buildingList = buildingDao.getBuildingByName(buildingname);
        Building loclbuilding=buildingList.get(0);
        return activityDao.MatchActivityName(loclbuilding.getId());
    }
}
