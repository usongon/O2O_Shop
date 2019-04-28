package cn.zdh.o2o.service;

import cn.zdh.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);

}
