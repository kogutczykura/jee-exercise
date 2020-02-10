package com.agata.jeeshop.controllers;

import com.agata.jeeshop.dto.AddProductToCartRequest;
import com.agata.jeeshop.dto.CartDto;
import com.agata.jeeshop.dto.CartItemDto;
import com.agata.jeeshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @PostMapping("/items")
    public ResponseEntity<CartDto> addCart(@RequestBody AddProductToCartRequest addProductToCartRequest) {
        CartDto cartDto = cartService.addToCart(addProductToCartRequest);
        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{cartId}/{cartItemId}")
    public ResponseEntity<CartItemDto> removePorduct(@PathVariable("cartId") final long cartId, @PathVariable("cartItemId") final long cartItemId){
        cartService.removeProduct(cartId, cartItemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
