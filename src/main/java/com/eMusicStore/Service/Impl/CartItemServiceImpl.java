package com.eMusicStore.Service.Impl;

import com.eMusicStore.Service.CartItemService;
import com.eMusicStore.dao.CartItemDao;
import com.eMusicStore.model.Cart;
import com.eMusicStore.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dilipan on 7/5/2016.
 */
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);

    }

    public void removeAllItems(Cart cart) {
        cartItemDao.removeAllItems(cart);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public CartItem getCartItemByProductIdCartItem(int productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }

    public void reduceQuantity(CartItem cartItem) {
         cartItemDao.reduceQuantity(cartItem);
    }
}
