package com.agata.jeeshop.controllers;

import com.agata.jeeshop.dto.CartDto;
import com.agata.jeeshop.models.OrderCreateRequest;
import com.agata.jeeshop.services.CartService;
import com.agata.jeeshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/order")
public class RestOrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderCreateRequest> submitOrder(@RequestBody OrderCreateRequest orderedCart){
        orderService.createOrder(orderedCart.getCartId());
        return new ResponseEntity<?>;
    }
}
