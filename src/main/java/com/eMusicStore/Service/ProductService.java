package com.eMusicStore.Service;

import com.eMusicStore.model.Product;

import java.util.List;

/**
 * Created by Dilipan on 6/29/2016.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
