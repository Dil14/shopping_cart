package com.eMusicStore.dao;

import com.eMusicStore.model.Cart;
import com.eMusicStore.model.Product;

import java.io.IOException;

/**
 * Created by Dilipan on 6/26/2016.
 */
public interface CartDao {


    Cart getCartById(int cartId);
    void updateCart(Cart cart);
    Cart validate(int cartId) throws IOException;

}
