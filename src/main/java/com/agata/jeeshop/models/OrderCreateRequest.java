package com.agata.jeeshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
public class OrderCreateRequest {

    private Long cartId;
    private String vorname;
    private String name;
    private String adress;
}
