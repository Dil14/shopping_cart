package com.eMusicStore.controller;

import com.eMusicStore.Service.ProductService;
import com.eMusicStore.dao.CustomerDao;
import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Customer;
import com.eMusicStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Dilipan on 6/29/2016.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Path path;
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("")
    public String showAdmin(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String showProductInventory(Model model){

        List<Product> product=productService.getProductList();
        model.addAttribute("products",product);

        return "productInventory";
    }

    @RequestMapping("/productInventory/addProduct")
    public String dislayAddProduct(Model model)
    {
        Product product =new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("New");
        product.setProductStatus("In Stock");

        model.addAttribute(product);
        return "addProduct";
    }



    @RequestMapping(value="/productInventory/addProduct",method = RequestMethod.POST)
    public String showAddProduct(@Valid @ModelAttribute("product") Product product,BindingResult result, HttpServletRequest request){

        System.out.println("In Admin errors");
        if(result.hasErrors()){
            return "addProduct";
        }

            productService.addProduct(product);

            MultipartFile productImage = product.getProductImage();

            String rootPath = request.getSession().getServletContext().getRealPath("/");

            path = Paths.get(rootPath + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

            System.out.println(path.toString());

            if (productImage != null && !productImage.isEmpty())
                try {
                    productImage.transferTo(new File(path.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("File cannot be saved");
                }


            return "redirect:/admin/productInventory";

    }



    @RequestMapping("/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable(value = "productId") int productId, Model model){
        Product product=productService.getProductById(productId);
        model.addAttribute(product);
        return "editProduct";
    }

    @RequestMapping(value="/productInventory/editProduct/{productId}",method = RequestMethod.POST)
    public String editPro(@PathVariable (value="productId") int productId,@ModelAttribute (value="product") Product product,
                          HttpServletRequest request){

        productService.editProduct(product);

        MultipartFile productImage=product.getProductImage();

        String rootPath=request.getSession().getServletContext().getRealPath("/");

        path=Paths.get(rootPath+"\\WEB-INF\\resources\\images\\"+productId+".png");

        if(Files.exists(path)){

            try {
                Files.delete(path);
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("File cannot be saved");
            }
        }
        else{
            try {
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "redirect:/admin/productInventory";
    }


    @RequestMapping("/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable (value = "productId") int productId,HttpServletRequest request){

        Product product=productService.getProductById(productId);
        productService.deleteProduct(product);

        String rootPath=request.getSession().getServletContext().getRealPath("/");

        path=Paths.get(rootPath+"\\WEB-INF\\resources\\images\\"+productId+".png");

        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/productInventory/viewProducts/{productId}")
    public String showEditProduct(@PathVariable (value="productId") int productId, Model model){
        Product product=productService.getProductById(productId);
        model.addAttribute(product);
        return "viewProducts";
    }

    @RequestMapping("/customerManagement")
    public String showCustomer(Model model){
        List<Customer> customers=customerDao.getCustomerList();
        model.addAttribute("customerList",customers);
        return "/customerManagement";
    }
}
