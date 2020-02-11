package com.agata.jeeshop.services;

import com.agata.jeeshop.dto.PurchaseOrderDto;
import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.OrderCreateRequest;
import com.agata.jeeshop.models.PurchaseOrder;
import com.agata.jeeshop.respositories.CartItemRepository;
import com.agata.jeeshop.respositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    public PurchaseOrderDto createOrder(OrderCreateRequest orderCreateRequest){
        Cart cart = cartRepository.getOne(orderCreateRequest.getCartId());

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setCartId(orderCreateRequest.getCartId());


        cartRepository.save();

        return null;
    }
}
