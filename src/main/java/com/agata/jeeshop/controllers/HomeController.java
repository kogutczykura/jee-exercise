package com.agata.jeeshop.controllers;


import com.agata.jeeshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("products", productService.findAll());
        mav.setViewName("home");
        return mav;
    }
}
