package com.eMusicStore.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dilipan on 6/29/2016.
 */
@Entity
public class ShippingAddress implements Serializable {


    private static final long serialVersionUID = 1378527652195004439L;
    @Id
    @GeneratedValue
    private int shippingAddressId;
    @NotEmpty(message = "streetName cannot be Empty")
    private String streetName;
    @NotEmpty(message = "apartmentNumber cannot be Empty")
    private String apartmentNumber;
    @NotEmpty(message = "city cannot be Empty")
    private String city;
    @NotEmpty(message = "state cannot be Empty")
    private String state;
    @NotEmpty(message = "country cannot be Empty")
    private String country;
    @NotEmpty(message = "zipcode cannot be Empty")
    private String zipcode;

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private Customer customer;

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "streetName='" + streetName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
