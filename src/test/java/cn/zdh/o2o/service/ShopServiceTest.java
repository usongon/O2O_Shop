package cn.zdh.o2o.service;

import cn.zdh.o2o.BaseTest;
import cn.zdh.o2o.dto.ShopExecution;
import cn.zdh.o2o.entity.Area;
import cn.zdh.o2o.entity.PersonInfo;
import cn.zdh.o2o.entity.Shop;
import cn.zdh.o2o.entity.ShopCategory;
import cn.zdh.o2o.enums.ShopStateEnum;
import cn.zdh.o2o.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest{

    @Autowired
    private ShopService shopService;

    @Test
    public void testModifyShop() throws ShopOperationException, FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的店名");
        File shioImg = new File("D://O2O_Img/logo.png");
        InputStream is = new FileInputStream(shioImg);
        ShopExecution shopExecution = shopService.modifyShop(shop, is, "logo.png");
        System.out.println("新的图片地址为：" + shopExecution.getShop().getShopImg());
    }

    @Test
    public void testAddShop() throws Exception{
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
        shop.setShopName("测试店铺333");
        shop.setShopDesc("test333");
        shop.setShopAddr("test333");
        shop.setPhone("test333");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopImg = new File("D://O2O_Img/bac.jpg");
        InputStream is = new FileInputStream(shopImg);

        ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }

    @Test
    public void testGetShopList(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition, 4, 2);
        System.out.println("店铺列表数为：" + se.getShopList().size());
        System.out.println("店铺总数为：" + se.getCount());
    }
}
