package com.agata.jeeshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean sold;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> items = new ArrayList<>();

    @OneToOne(mappedBy = "cart") PurchaseOrder purchaseOrder;
}
