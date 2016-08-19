package com.eMusicStore.dao;

import com.eMusicStore.model.Cart;
import com.eMusicStore.model.CartItem;

/**
 * Created by Dilipan on 7/5/2016.
 */
public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllItems(Cart cart);

    void reduceQuantity(CartItem cartItem);

    CartItem getCartItemByProductId(int productId);


}
