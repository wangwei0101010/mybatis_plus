package com.mybatisplus.first.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.first.entity.Area;
import java.util.List;

public interface AreaDao extends BaseMapper<Area> {

  List<Area> quearyArea();
  Area queryAreaById(int areaId);
  int insertArea(Area area);
  int updateArea(Area area);
  int deleteArea(int areaId);

}
