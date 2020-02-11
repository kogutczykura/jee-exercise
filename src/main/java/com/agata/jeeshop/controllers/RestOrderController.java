package com.agata.jeeshop.controllers;

import com.agata.jeeshop.dto.CartDto;
import com.agata.jeeshop.models.OrderedCart;
import com.agata.jeeshop.services.CartService;
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

    @PostMapping
    public ResponseEntity<OrderedCart> submitOrder(@RequestBody OrderedCart orderedCart){
        CartDto cartDto = cartService.addToOrdered(orderedCart.getCartId());
        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
    }
}
