package cn.zdh.o2o.service;

import cn.zdh.o2o.dto.ImageHolder;
import cn.zdh.o2o.dto.ProductExecution;
import cn.zdh.o2o.entity.Product;
import cn.zdh.o2o.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

public interface ProductService {


    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
            throws ProductOperationException;

    /**
     * 通过商品Id查询唯一的商品信息
     * @param productId
     * @return
     */
    Product getProductById(Long productId);

    /**
     * 修改图片信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
                                   List<ImageHolder> productImgHolderList) throws  ProductOperationException;

}
