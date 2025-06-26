package com.cafuc.icfb.controller;

import com.cafuc.icfb.entity.CData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TestyoloController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/yolo")
    public Integer activitieslist(){
        //recorderService.DeleteRecorderByTime(null,localDateTime.format(dtf));
        String updateurl="http://192.168.110.194:5000/processimg?url=/1/111.jpg";
        Integer i=1;
        return restTemplate.postForObject(updateurl, i, Integer.class);
    }
}
