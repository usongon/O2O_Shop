package cn.zdh.o2o.service;

import cn.zdh.o2o.dto.ImageHolder;
import cn.zdh.o2o.dto.ShopExecution;
import cn.zdh.o2o.entity.Shop;
import cn.zdh.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /**
     * 通过shopId获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(Long shopId);

    /**
     * 更新店铺信息， 包括对图片的处理
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /**
     * 根据ShopCondition分页返回相应列表数据
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

}
