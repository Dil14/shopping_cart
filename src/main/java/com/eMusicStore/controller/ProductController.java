package com.eMusicStore.controller;

import com.eMusicStore.Service.ProductService;
import com.eMusicStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Dilipan on 6/29/2016.
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String showProducts(Model model)
    {
        List<Product> product= productService.getProductList();
        model.addAttribute("product",product);
        return "productList";
    }

    @RequestMapping("/viewProducts/{productId}")
    public String showEditProduct(@PathVariable (value="productId") int productId, Model model){
        Product product=productService.getProductById(productId);
        model.addAttribute(product);
        return "viewProducts";
    }

}
