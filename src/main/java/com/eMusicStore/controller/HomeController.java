package com.eMusicStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dilipan on 6/29/2016.
 */

@Controller
public class HomeController {

    @Autowired
    private CookieCsrfTokenRepository csrfTokenRepository;

    @RequestMapping("/")
    public String showHome(){
        return "home";
    }

    @RequestMapping("/login")
    public String showLogin(@RequestParam (value = "error" ,required=false) String error,
                            @RequestParam(value="logout", required=false) String logout, Model model,
                            HttpServletResponse response,HttpServletRequest request){

       String token= csrfTokenRepository.generateToken(request).toString();

        csrfTokenRepository.setCookieName("X-CSRF-TOKEN");

        response.addHeader("X-CSRF-TOKEN",token);

        System.out.println("csrf generated"+token);

        if(error!=null){

            model.addAttribute("error","Invalid Username or Password");

        }

        if(logout!=null){
            model.addAttribute("msg","You have been successfully Logged Out of the Account");
        }




        return "login";
    }
}
