package com.cafuc.icfb.DAO;

import com.cafuc.icfb.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    List<Activity> getActivitiesList(int pagesize, int offset);
    List<Activity> getActivitiesListAll();
    Integer addActivity(Integer buildingid, String acquisitionname, String time);
    Integer deleteActivity(String acquisitionname);
    List<Activity> MatchActivityName(int buildingId);
    Integer getActivityId(String acquisitionname);
}