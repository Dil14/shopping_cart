package com.eMusicStore.controller;

import com.eMusicStore.Service.CustomerOrderService;
import com.eMusicStore.dao.CartDao;
import com.eMusicStore.model.Cart;
import com.eMusicStore.model.Customer;
import com.eMusicStore.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dilipan on 7/7/2016.
 */
@Controller
public class CustomerOrderController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String showOrder(@PathVariable (value="cartId")int cartId){

        CustomerOrder customerOrder =new CustomerOrder();
        Cart cart= cartDao.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer=cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
        customerOrderService.addCustomerOrder(customerOrder);


        return "redirect:/checkout?cartId="+cartId;
    }
}
