package com.eMusicStore.Service;

import com.eMusicStore.model.Cart;

/**
 * Created by Dilipan on 7/5/2016.
 */
public interface CartService {

    Cart getCartById(int cartId);
    void updateCart(Cart cart);
}
