package com.eMusicStore.Service.Impl;

import com.eMusicStore.Service.CustomerOrderService;
import com.eMusicStore.dao.CartDao;
import com.eMusicStore.dao.CustomerOrderDao;
import com.eMusicStore.model.Cart;
import com.eMusicStore.model.CartItem;
import com.eMusicStore.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dilipan on 7/7/2016.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {


    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartDao cartDao;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getGrandTotal(int cartId) {
        double grandtotal=0;
        Cart cart=cartDao.getCartById(cartId);
        List<CartItem> cartItems=cart.getCartItems();

        for(CartItem item:cartItems){
            grandtotal+=item.getTotalprice();
        }
        return grandtotal;
    }
}
