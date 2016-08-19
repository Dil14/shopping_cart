package com.eMusicStore.dao;

import com.eMusicStore.model.Customer;

import java.util.List;

/**
 * Created by Dilipan on 6/30/2016.
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getCustomerList();

    Customer getCustomerByUsername(String username);
}
