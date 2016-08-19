package com.eMusicStore.Service;

import com.eMusicStore.model.CustomerOrder;

/**
 * Created by Dilipan on 7/7/2016.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);
    double getGrandTotal(int cartId);
}
