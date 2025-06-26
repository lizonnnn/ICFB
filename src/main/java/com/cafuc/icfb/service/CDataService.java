package com.cafuc.icfb.service;

import com.cafuc.icfb.DAO.ActivityDao;
import com.cafuc.icfb.DAO.CDataDao;
import com.cafuc.icfb.DAO.DDataDao;
import com.cafuc.icfb.entity.Activity;
import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.entity.CData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestOperations;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CDataService {
    @Autowired
    private CDataDao cDataDao;
    @Autowired
    private DDataDao dDataDao;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    RestOperations restTemplate;
    @Value("${file.upload.path}")
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
            return addcdata(captureid, internalnumber, fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public Integer addcdata(Integer captureid, Integer internalnumber, String url) {
        List<CData> cDataListList = cDataDao.getCDataListAll();

        for (CData u : cDataListList) {
            if (u.getUrl().equals(url)) {
                return 0;
            }
        }
        List<Activity> activitiesList = activityDao.getActivitiesListAll();
        for (Activity u : activitiesList) {
            if (u.getId() == captureid) {
                cDataDao.addCData(captureid, internalnumber, url);
                String updateurl="http://192.168.110.194:5000/processimg?url="+url;
                InputStream inputStream = restTemplate.execute(
                        updateurl,
                        HttpMethod.GET,
                        null,
                        response -> response.getBody()
                );
                BufferedImage bi;
                // 转换为BufferedImage
                try {
                    bi=ImageIO.read(inputStream);
                    dDataDao.addDData(captureid, internalnumber, url);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return 1;
//                String updateurl="http://192.168.110.194:5000/processimg?url=/1/111.jpg";
//                Integer i=1;
//                RestOperations restTemplate;
//                return restTemplate.postForObject(updateurl, i, Integer.class);
            }
        }
        return 0;
    }

    public int WorkoutService(String url) {
        return cDataDao.deleteCData(url);
    }

    public List<CData> CDataSearchService(int page, int pagesize) {
        if(page>=1){
            List<CData> cDataList = cDataDao.getCDataList(pagesize,(page-1)*pagesize);
            return cDataList;
        }
        else
            return null;
    }
}
