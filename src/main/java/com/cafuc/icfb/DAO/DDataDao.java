package com.cafuc.icfb.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.cafuc.icfb.entity.CData;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DDataDao {
    List<CData> getDDataListAll();
    Integer addDData(Integer captureid, Integer internalnumber, String url);
    int deleteDData(String url);
    List<CData> getDDataList(int pagesize, int offset);
}
