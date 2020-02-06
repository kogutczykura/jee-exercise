package com.agata.jeeshop.dto;

import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartDto {

    private Long id;
    private List<CartItemDto> items = new ArrayList<>();


}
