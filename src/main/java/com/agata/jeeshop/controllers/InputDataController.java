package com.agata.jeeshop.controllers;

import com.agata.jeeshop.models.OrderCreateRequest;
import com.agata.jeeshop.services.CartService;
import com.agata.jeeshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orderForm")
public class InputDataController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderCreateRequest> addDataToFrom(@RequestBody OrderCreateRequest orderCreateRequest){
        //OrderCreateRequest
        return null;
    }

    @GetMapping("/{cartId}")
    public ModelAndView getInfoFromForm(@PathVariable("id") final long id){
        ModelAndView mav = new ModelAndView();
        // mav.addObject("cartId", orderService.createOrder());
        return mav;
    }

}
