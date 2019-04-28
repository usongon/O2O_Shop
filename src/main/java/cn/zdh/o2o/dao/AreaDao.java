package cn.zdh.o2o.dao;

import cn.zdh.o2o.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
