package com.agata.jeeshop.controllers;

import com.agata.jeeshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class LearnController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(){
        return "hello";
    }

    @GetMapping("/modelAndView/{name}")
    public ModelAndView modelAndView(@PathVariable("name") final String name, @RequestParam("age") final int age) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);
        mav.addObject("age", age);
        mav.setViewName("name");
        return mav;
    }

    @GetMapping("/product/{id}")
    public ModelAndView product(@PathVariable("id") final Long id, @RequestParam("active") final boolean active){
        ModelAndView mav = new ModelAndView();
        mav.addObject("id", id);
        mav.addObject("product", productService.findById(id));
        mav.addObject("active", active);
        mav.setViewName("product");
        return mav;
    }
}
