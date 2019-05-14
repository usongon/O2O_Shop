package cn.zdh.o2o.dao;

import cn.zdh.o2o.entity.Product;

public interface ProductDao {

    /**
     * 插入商品
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     * 通过productId查询商品
     * @param productId
     * @return
     */
    Product queryProductById(Long productId);

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    int updateProduct(Product product);

}
