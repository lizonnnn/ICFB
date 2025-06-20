package com.cafuc.icfb.service;

import java.util.ArrayList;
import java.util.List;
import com.cafuc.icfb.DAO.ActivityDao;
import com.cafuc.icfb.DAO.BuildingDao;
import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.Building;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private BuildingDao buildingDao;

    public List<Activity> ActivitiesSearchService(int page, int pagesize) {
        if(page>=1){
            List<Activity> activitiesList = activityDao.getActivitiesList(pagesize,(page-1)*pagesize);
            return activitiesList;
        }
        else
            return null;
    }

    public Integer addactivity(Integer buildingid, String acquisitionname, String time) {
        List<Activity> activitiesList = activityDao.getActivitiesListAll();
        for (Activity u : activitiesList) {
            if (u.getAcquisitionName().equals(acquisitionname)) {
                return 0;
            }
        }
        return activityDao.addActivity(buildingid, acquisitionname, time); // 插入成功返回 1
    }

    public Integer WorkoutService(String Acquisitionname) {
        return activityDao.deleteActivity(Acquisitionname);
    }

//    public List<String> matchBuilding(String acquisitionname) {
//        List<Activity> activitiesList = activityDao.getActivitiesListAll();
//        List<String> temp = new ArrayList<>();
//        for (Activity i : activitiesList){
//            if(i.getAcquisitionName().equals(acquisitionname)){
//                temp = buildingDao.MatchBuildingName(i.getBuildingId());
//            }
//        }
//        return temp;
//    }
}
