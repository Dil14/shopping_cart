package com.eMusicStore.Service.Impl;

import com.eMusicStore.Service.ProductService;
import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dilipan on 6/29/2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(int productId)
    {
        return productDao.getProductById(productId);
    }

    public List<Product> getProductList(){
       return productDao.getProductList();
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
