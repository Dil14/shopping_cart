package com.eMusicStore.Service.Impl;

import com.eMusicStore.Service.CustomerService;
import com.eMusicStore.dao.CustomerDao;
import com.eMusicStore.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Dilipan on 6/30/2016.
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return  customerDao.getCustomerById(customerId);
    }

    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();

         }
    public Customer getCustomerByUsername(String username){
        return customerDao.getCustomerByUsername(username);
    }
}
