package com.eMusicStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Dilipan on 6/21/2016.
 */
@Entity
public class Product implements Serializable{


    private static final long serialVersionUID = 8640149212941872622L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;


    @NotEmpty(message = "Product Name cannot be Empty")
    private  String productName;

    @NotEmpty(message = "Product Category cannot be Empty")
    private String productCategory;

    @NotEmpty(message = "Product Description cannot be Empty")
    private String productDescription;

    @Min(value=0,message = "Price cannot be less than Zero")
    private double productPrice;

    @NotEmpty(message = "Product Condition cannot be Empty")
    private String productCondition;

    @NotEmpty(message = "Product Status cannot be Empty")
    private String productStatus;

    @Min(value=0,message = "In Stock cannot be less than Zero")
    private int unitInStock;

    @NotEmpty(message = "Product Manufacturer cannot be Empty")
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItem) {
        this.cartItems = cartItems;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }
}
