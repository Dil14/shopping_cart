package com.eMusicStore.controller;

import com.eMusicStore.Service.CustomerService;
import com.eMusicStore.dao.CustomerDao;
import com.eMusicStore.model.BillingAddress;
import com.eMusicStore.model.Customer;
import com.eMusicStore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dilipan on 6/30/2016.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/register")
    public String showRegister(Model model){
        Customer customer=new Customer();
        BillingAddress billingAddress=new BillingAddress();
        ShippingAddress shippingAddress=new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute(customer);

        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String showRegPost(@Valid @ModelAttribute (value="customer") Customer customer,BindingResult result,Model model){

        System.out.println("Error Count"+result.getErrorCount());

        if(result.hasErrors()){
            return "register";
        }


        List<Customer> customerList =customerDao.getCustomerList();

        for(int i=0;i<customerList.size();i++){
            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())){
                model.addAttribute("Email_error","Email Id already exists");
                return  "register";
            }
            if(customer.getUsername().equals(customerList.get(i).getUsername())){
                model.addAttribute("Username_error","Username already exists");
                return  "register";
            }
        }
            customerDao.addCustomer(customer);

            return "success";

    }
}
