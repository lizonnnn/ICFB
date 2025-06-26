package com.cafuc.icfb.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Integer result = activityDao.addActivity(buildingid, acquisitionname, time);
        if (result > 0) {
            try {
                // 定义文件夹路径
                String basePath = "C:\\Users\\86178\\Desktop\\挑战杯\\ICFB-master\\src\\main\\resources\\static\\collectimg";
                String folderName = Integer.toString(activityDao.getActivityId(acquisitionname)); // 直接使用活动名称作为文件夹名
                File folder = new File(Paths.get(basePath, folderName).toString());
                // 创建文件夹（如果不存在）
                if (!folder.exists()) {
                    boolean created = folder.mkdir();
                    if (!created) {
                        System.err.println("Failed to create directory: " + folder.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 递归删除目录 以及 其中内容
    private boolean deleteDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectory(file);
                }
            }
        }
        return directory.delete();
    }

    public Integer WorkoutService(String Acquisitionname) {
        try {
            // 定义文件夹路径
            String basePath = "C:/Users/86178/Desktop/挑战杯/ICFB-master/src/main/resources/static/collectimg";
            String folderName = Integer.toString(activityDao.getActivityId(Acquisitionname));
            File folder = new File(Paths.get(basePath, folderName).toString());

            // 删除文件夹（如果存在）
            if (folder.exists() && folder.isDirectory()) {
                boolean deleted = deleteDirectory(folder);
                if (!deleted) {
                    System.err.println("文件夹删除失败: " + folder.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 即使文件夹删除失败，也不影响数据库操作结果
        }

        Integer result = activityDao.deleteActivity(Acquisitionname);

        return result;
    }

}
