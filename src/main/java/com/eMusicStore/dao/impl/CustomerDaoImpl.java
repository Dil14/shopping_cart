package com.eMusicStore.dao.impl;

import com.eMusicStore.dao.CustomerDao;
import com.eMusicStore.model.Authorities;
import com.eMusicStore.model.Cart;
import com.eMusicStore.model.Customer;
import com.eMusicStore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dilipan on 6/30/2016.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {

        Session session=sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users user=new Users();
        user.setCustomerId(customer.getCustomerId());
        user.setUsername(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setEnabled(true);

        Authorities authorities=new Authorities();
        authorities.setUsername(customer.getUsername());
        authorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(user);
        session.saveOrUpdate(authorities);

        Cart cart=new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        session.saveOrUpdate(cart);
        session.saveOrUpdate(customer);

        session.flush();
    }

    public Customer getCustomerById(int customerId) {
        Session session=sessionFactory.getCurrentSession();
        Customer customer= (Customer) session.get(Customer.class,customerId);
        session.flush();
        return customer;
    }

    public List<Customer> getCustomerList() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer");
        List<Customer> customers=query.list();
        return customers;
    }

    public Customer getCustomerByUsername(String username){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where username=?");
        query.setString(0,username);
        return (Customer) query.uniqueResult();
    }
}
