package com.cafuc.icfb.service;

import com.cafuc.icfb.DAO.ActivityDao;
import com.cafuc.icfb.DAO.CDataDao;
import com.cafuc.icfb.DAO.DDataDao;
import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.CData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
@Service
public class DDataService {
    @Autowired
    private DDataDao dDataDao;
    @Autowired
    private ActivityDao activityDao;
    @Value("${file.upload.path1}")
    private String uploadPath;
    public Integer addcdataconrebuild(Integer captureid,
                                      Integer internalnumber,
                                      MultipartFile photo){
        try {
            // 3. 生成唯一文件名
            String originalFileName = photo.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = internalnumber.toString() + fileExtension;
            // 4. 创建上传目录(如果不存在)
            File uploadDir = new File(uploadPath+"/"+captureid.toString());
            if (!uploadDir.exists()) {
                return 0;
            }

            // 5. 保存文件
            File dest = new File(uploadDir + File.separator + uniqueFileName);
            photo.transferTo(dest);

            // 6. 生成可访问的URL路径
            String fileUrl ="\\images"  + File.separator + uniqueFileName;

            // 7. 调用原有服务方法
            return addddata(captureid, internalnumber, fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public Integer addddata(Integer captureid, Integer internalnumber, String url) {
        List<CData> cDataListList = dDataDao.getDDataListAll();
        for (CData u : cDataListList) {
            if (u.getUrl().equals(url)) {
                return 0;
            }
        }
        List<Activity> activitiesList = activityDao.getActivitiesListAll();
        for (Activity u : activitiesList) {
            if (u.getId() == captureid) {
                return dDataDao.addDData(captureid, internalnumber, url);
            }
        }
        return 0;
    }

    public int WorkoutService(String url) {
        return dDataDao.deleteDData(url);
    }

    public List<CData> CDataSearchService(int page, int pagesize) {
        if(page>=1){
            List<CData> dDataList = dDataDao.getDDataList(pagesize,(page-1)*pagesize);
            return dDataList;
        }
        else
            return null;
    }
}
