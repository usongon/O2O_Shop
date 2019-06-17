package cn.zdh.o2o.dao;

import cn.zdh.o2o.BaseTest;
import cn.zdh.o2o.entity.Area;
import cn.zdh.o2o.entity.PersonInfo;
import cn.zdh.o2o.entity.Shop;
import cn.zdh.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest{

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInserShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwner(owner);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("123434");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }
    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testQueryByShopId(){
        Long shopId = 1L;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("AreaId: " + shop.getArea().getAreaId());
        System.out.println("AreaName: " + shop.getArea().getAreaName());
    }

    @Test
    public void testQueryShopListAndCount(){
        Shop shopCondition = new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(14L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        System.out.println("店铺列表的大小：" + shopList.size());
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺总数为：" + count);
    }
}
