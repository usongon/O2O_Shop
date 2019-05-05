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

}
