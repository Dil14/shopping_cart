package com.eMusicStore.controller;

import com.eMusicStore.Service.CustomerService;
import com.eMusicStore.dao.CustomerDao;
import com.eMusicStore.model.Customer;
import com.eMusicStore.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dilipan on 7/1/2016.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerDao customerDao;
    @RequestMapping("")
    public String showCart(@AuthenticationPrincipal User user){
        Customer customer=customerDao.getCustomerByUsername(user.getUsername());
        System.out.println(user.getUsername())  ;
        int cartId=customer.getCart().getCartId();
        System.out.println("cartId"+cartId)  ;
        return "redirect:/customer/cart/"+cartId;
    }

    @RequestMapping("/{cartId}")
    public String showCartpost(Model model, @PathVariable (value = "cartId") int cartId){

        model.addAttribute("cartId",cartId);

       return "cart";
    }

}
