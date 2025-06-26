package com.cafuc.icfb.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.cafuc.icfb.entity.CData;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CDataDao {
    List<CData> getCDataListAll();
    Integer addCData(Integer captureid, Integer internalnumber, String url);
    int deleteCData(String url);
    List<CData> getCDataList(int pagesize, int offset);
}
