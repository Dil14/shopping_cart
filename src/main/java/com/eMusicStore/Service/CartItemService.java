package com.eMusicStore.Service;

import com.eMusicStore.model.Cart;
import com.eMusicStore.model.CartItem;

/**
 * Created by Dilipan on 7/5/2016.
 */
public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void reduceQuantity(CartItem cartItem);

    void removeAllItems(Cart cart);

    CartItem getCartItemByProductIdCartItem(int productId);
}
