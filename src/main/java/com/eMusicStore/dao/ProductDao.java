package com.eMusicStore.dao;

import com.eMusicStore.model.Product;

import java.util.List;

/**
 * Created by Dilipan on 6/23/2016.
 */
public interface ProductDao {

     List<Product> getProductList();

     Product getProductById(int id);

     void addProduct(Product product);

     void editProduct(Product product);

     void deleteProduct(Product product);
}
