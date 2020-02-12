package com.agata.jeeshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderDto {
    private Long id;
    private Long cartId;

    private String firstName;
    private String lastName;
    private String email;
}
