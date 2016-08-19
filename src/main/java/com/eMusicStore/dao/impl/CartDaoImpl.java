package com.eMusicStore.dao.impl;

import com.eMusicStore.Service.CartService;
import com.eMusicStore.Service.CustomerOrderService;
import com.eMusicStore.dao.CartDao;
import com.eMusicStore.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by Dilipan on 7/5/2016.
 */

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

@Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CustomerOrderService customerOrderService;
    public Cart getCartById(int cartId) {
        Session session=sessionFactory.getCurrentSession();
        Cart cart=(Cart) session.get(Cart.class,cartId) ;
        session.flush();
        return cart;
    }

    public void updateCart(Cart cart) {
        Session session=sessionFactory.getCurrentSession();
        int cartId=cart.getCartId();
        double grandTotal=customerOrderService.getGrandTotal(cartId);
        cart.setGrandtotal(grandTotal);
        session.saveOrUpdate(cart);
        session.flush();
    }

    public Cart validate(int cartId) throws IOException {

        System.out.println("In Validate Method"+cartId);
        Cart cart=getCartById(cartId);
        System.out.println("Size of Cart"+cart.getCartItems().size());
        if(cart==null || cart.getCartItems().size()==0){
            System.out.println("In exception");
            throw new IOException(cartId+"");
        }
        System.out.println("Out exception");
        updateCart(cart);
        System.out.println("Size of Cart"+cart.getCartItems().size());
        return cart;
    }
}
