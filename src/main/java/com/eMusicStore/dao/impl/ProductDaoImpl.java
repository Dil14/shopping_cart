package com.eMusicStore.dao.impl;

import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

/**
 * Created by Dilipan on 6/23/2016.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Product getProductById(int productId){

        Session session=sessionFactory.getCurrentSession();
        Product product= (Product) session.get(Product.class,productId);
        session.flush();
        return product;
    }

    public List<Product> getProductList(){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product");
        List<Product> product=query.list();
        return product;
    }

    public void addProduct(Product product){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }
    public void editProduct(Product product){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product){
        Session session=sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

}
