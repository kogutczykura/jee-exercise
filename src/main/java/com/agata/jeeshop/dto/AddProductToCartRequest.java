package com.agata.jeeshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddProductToCartRequest {
    private long cartId;
    private Long productId;
}
