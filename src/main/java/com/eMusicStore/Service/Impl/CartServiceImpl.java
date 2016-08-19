package com.eMusicStore.Service.Impl;

import com.eMusicStore.Service.CartService;
import com.eMusicStore.dao.CartDao;
import com.eMusicStore.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dilipan on 7/5/2016.
 */
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}
