package com.cafuc.icfb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CDataAddPicController {
    @GetMapping("/upload")
    public String uploadPage() {
        return "uploadimg"; // 对应 uploadimg.ftl
    }
}
