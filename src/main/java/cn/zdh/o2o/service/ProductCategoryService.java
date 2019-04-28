package cn.zdh.o2o.service;

import cn.zdh.o2o.dto.ProductCategoryExecution;
import cn.zdh.o2o.entity.ProductCategory;
import cn.zdh.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(Long shopId);

    /**
     * 批量添加
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
        throws ProductCategoryOperationException;

    /**
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws RuntimeException
     */
    ProductCategoryExecution deleteProductCategory(Long productCategoryId,
                                                   Long shopId) throws RuntimeException;

}
