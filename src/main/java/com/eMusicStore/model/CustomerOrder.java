package com.eMusicStore.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dilipan on 6/29/2016.
 */
@Entity
public class CustomerOrder implements Serializable {


    private static final long serialVersionUID = 4073036600457999608L;

    @Id
    @GeneratedValue
    private int customerId;

    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="shoppingAddressId")
    private ShippingAddress shippingAddress;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
