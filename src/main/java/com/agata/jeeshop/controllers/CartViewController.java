package com.agata.jeeshop.controllers;

import com.agata.jeeshop.dto.CartItemDto;
import com.agata.jeeshop.dto.ProductDto;
import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.CartItem;
import com.agata.jeeshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartViewController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ModelAndView getCartView(@PathVariable("id") final long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("cart", cartService.findById(id));
        mav.addObject("totalAmount", cartService.calculateTotalAmount(id));
        mav.setViewName("cart");
        return mav;
    }

     @DeleteMapping("/{cartId}/{cartItemId}")
     public ResponseEntity<CartItemDto> removePorduct(@PathVariable("cartId") final long cartId, @PathVariable("cartItemId") final long cartItemId){

         return new ResponseEntity<>(HttpStatus.OK);
      }
}
