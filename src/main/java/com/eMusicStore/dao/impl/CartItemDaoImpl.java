package com.eMusicStore.dao.impl;

import com.eMusicStore.dao.CartItemDao;
import com.eMusicStore.model.Cart;
import com.eMusicStore.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dilipan on 7/5/2016.
 */

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllItems(Cart cart) {
        List<CartItem> cartItems =cart.getCartItems();
        for(CartItem item: cartItems){
          removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(int productId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CartItem where productId=?");
        query.setParameter(0,productId);
        session.flush();
        return (CartItem) query.uniqueResult();
    }

    public void reduceQuantity(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        int quantity=0;
        quantity=cartItem.getQuantity();
        double price=cartItem.getTotalprice()/quantity;
        cartItem.setQuantity(cartItem.getQuantity()-1);
        cartItem.setTotalprice(cartItem.getTotalprice()-price);
        System.out.println("Quantity in Dao"+cartItem.getQuantity());
        session.saveOrUpdate(cartItem);
        session.flush();
    }
}
