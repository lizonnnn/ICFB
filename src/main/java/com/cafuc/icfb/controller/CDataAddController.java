package com.cafuc.icfb.controller;

import com.cafuc.icfb.DAO.CDataDao;
import com.cafuc.icfb.service.ActivityService;
import com.cafuc.icfb.service.CDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class CDataAddController {
    @Autowired
    CDataService cDataService;

    @Value("${file.upload.path}")
    private String uploadPath;
    @PostMapping("/addcdata")
    public Integer cdataadd(
           @RequestParam("captureid") Integer captureid,
           @RequestParam("internalnumber") Integer internalnumber,
            @RequestParam("photo") MultipartFile photo) {
        return cDataService.addcdataconrebuild(captureid,internalnumber,photo);
    }
//    public Integer cdataadd(
//            @RequestParam("captureid") Integer captureid,
//            @RequestParam("internalnumber") Integer internalnumber,
//            @RequestParam("photo") MultipartFile photo) {
//        try {
//            // 3. 生成唯一文件名
//            String originalFileName = photo.getOriginalFilename();
//            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//            String uniqueFileName = internalnumber.toString() + fileExtension;
//            // 4. 创建上传目录(如果不存在)
//            File uploadDir = new File(uploadPath+"/"+captureid.toString());
//            if (!uploadDir.exists()) {
//                return 0;
//            }
//
//            // 5. 保存文件
//            File dest = new File(uploadDir + File.separator + uniqueFileName);
//            photo.transferTo(dest);
//
//            // 6. 生成可访问的URL路径
//            String fileUrl ="\\images"  + File.separator + uniqueFileName;
//
//            // 7. 调用原有服务方法
//            return cDataService.addcdata(captureid, internalnumber, fileUrl);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
}
