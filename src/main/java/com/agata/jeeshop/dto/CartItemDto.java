package com.agata.jeeshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {

    private Long id;
    private Long productId;
    private String productName;
    private double productPrice;
}
