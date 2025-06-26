package com.cafuc.icfb.controller;

import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.entity.User;
import com.cafuc.icfb.service.BuildingService;
import com.cafuc.icfb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BuildingAddController {
    @Autowired
    BuildingService buildingService;

    @RequestMapping("/addbuilding")
    public ModelAndView buildingadd(
            @RequestParam("buildname") String buildname,
            @RequestParam("introduction") String introduction) {

        Integer result = buildingService.addBuilding(buildname,introduction);

        if (result == 1) {
            return new ModelAndView("center");
        } else {
            ModelAndView mv = new ModelAndView("buildingadd");
            mv.addObject("error", "此建筑已存在！");
            return mv;
        }
    }

}
