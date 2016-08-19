package com.eMusicStore.controller;

import com.eMusicStore.Service.CartItemService;
import com.eMusicStore.Service.CartService;
import com.eMusicStore.dao.CartDao;
import com.eMusicStore.dao.CartItemDao;
import com.eMusicStore.dao.CustomerDao;
import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dilipan on 7/5/2016.
 */

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartItemDao cartItemDao;


    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart showCart(@PathVariable (value="cartId") int cartId){
        return cartDao.getCartById(cartId);
    }

    @RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void showAddProduct(@PathVariable (value="productId") int productId, @AuthenticationPrincipal User users){

        Customer customer=customerDao.getCustomerByUsername(users.getUsername());
        System.out.println("In resource Username"+users.getUsername());
        Cart cart=customer.getCart();
        System.out.println("In resource cart"+cart);
        Product product=productDao.getProductById(productId);
        List<CartItem> cartItems=cart.getCartItems();
        for(int i=0;i<cartItems.size();i++){
            if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
                CartItem  cartItem=cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalprice(cartItem.getQuantity()*product.getProductPrice());
                cartItemDao.addCartItem(cartItem);
                return;
            }
        }
        CartItem  cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalprice(cartItem.getQuantity()*product.getProductPrice());
        cartItem.setCart(cart);
        cartItemDao.addCartItem(cartItem);

    }

    @RequestMapping(value="/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable(value = "productId") int productId){
        CartItem cartItem=cartItemDao.getCartItemByProductId(productId);
        System.out.println("Cart details"+cartItem.getQuantity());
        if (cartItem.getQuantity() > 1) {

            cartItemDao.reduceQuantity(cartItem);
        }else{
            cartItemDao.removeCartItem(cartItem);
        }

    }

    @RequestMapping(value="/{cartId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearAll(@PathVariable (value="cartId") int cartId){
        Cart cart=cartDao.getCartById(cartId);
        cartItemDao.removeAllItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad payload")
    public void handleClient(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleClientError(Exception e){}
}
