package cn.zdh.o2o.dao;

import cn.zdh.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过ShopId查询店铺商铺类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(Long shopId);

    /**
     * 批量新增商品类别
     * @param productCategoryList
     * @return
     */
    int batchInserProductCategory(List<ProductCategory> productCategoryList);

    /**
     *  删除商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") Long productCategoryId, @Param("shopId") Long shopId);
}
