package cn.zdh.o2o.dao;

import cn.zdh.o2o.BaseTest;
import cn.zdh.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryDaoTest extends BaseTest{

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryProductList(){
        Long shopId = 1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
    }

}
