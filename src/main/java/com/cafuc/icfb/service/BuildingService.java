package com.cafuc.icfb.service;

import com.cafuc.icfb.DAO.BuildingDao;
import com.cafuc.icfb.DAO.UserDao;
import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingDao buildingDao;

    public List<Building> BuildingSearchService(int page,int pagesize) {
        if(page>=1){
            List<Building> buildingList = buildingDao.getBuildingList(pagesize,(page-1)*pagesize);
            return buildingList;
        }
        else
            return null;
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
}
