package com.cafuc.icfb.DAO;

import com.cafuc.icfb.entity.Building;
import com.cafuc.icfb.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BuildingDao {
    List<Building> getBuildingListAll();
    List<Building> getBuildingList(int pagesize, int offset);
    Integer addBuilding(String buildname,String introduction);
    Integer deleteBuilding(String buildname);
}
