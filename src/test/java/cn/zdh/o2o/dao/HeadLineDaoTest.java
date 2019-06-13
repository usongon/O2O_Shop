package cn.zdh.o2o.dao;

import cn.zdh.o2o.BaseTest;
import cn.zdh.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeadLineDaoTest extends BaseTest {
    @Autowired
    protected HeadLineDao headLineDao;

    @Test
    public void testQueryArea(){
        List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
        assertEquals(1, headLineList.size());
    }
}
