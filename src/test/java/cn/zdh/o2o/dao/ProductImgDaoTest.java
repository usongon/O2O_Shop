package cn.zdh.o2o.dao;

import cn.zdh.o2o.BaseTest;
import cn.zdh.o2o.entity.ProductImg;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest{
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testABatchInserProductImg() throws Exception{
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("img11");
        productImg1.setImgDesc("test img11");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);

        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("img22");
        productImg2.setImgDesc("test img22");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1L);

        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testCDeleteProductImgByProductId() throws Exception{
        //删除新增的两条商品详情图记录
        Long productId = 1L;
        int effectedNum = productImgDao.deleteProductImgByProductId(productId);
        assertEquals(2, effectedNum);
    }
}
