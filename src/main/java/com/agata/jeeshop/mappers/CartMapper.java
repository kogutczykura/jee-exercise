package com.agata.jeeshop.mappers;

import com.agata.jeeshop.dto.CartDto;
import com.agata.jeeshop.dto.CartItemDto;
import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.CartItem;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDto toDto(Cart cart) {
        if(cart == null) {
            return null;
        }

        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setItems(cart.getItems().stream().map(cartItem -> this.cartItemToDto(cartItem)).collect(Collectors.toList()));
        return cartDto;
    }

    public CartItemDto cartItemToDto(CartItem cartItem){
        CartItemDto cartItemDto = new CartItemDto();
        BeanUtils.copyProperties(cartItem, cartItemDto);
        return cartItemDto;
    }

    public CartItem fromDto(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(cartItemDto, cartItem);
        return cartItem;
    }

}
