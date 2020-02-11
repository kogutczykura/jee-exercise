package com.agata.jeeshop.services;

import com.agata.jeeshop.dto.PurchaseOrderDto;
import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.OrderCreateRequest;
import com.agata.jeeshop.models.PurchaseOrder;
import com.agata.jeeshop.respositories.CartItemRepository;
import com.agata.jeeshop.respositories.CartRepository;
import com.agata.jeeshop.respositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public PurchaseOrderDto createOrder(OrderCreateRequest orderCreateRequest){
        Cart cart;
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();

        cart = cartRepository.getOne(orderCreateRequest.getCartId());
        cart.setSold(true);
        purchaseOrder.setCart(cart);

        cartRepository.save(cart);
        orderRepository.save(purchaseOrder);

        purchaseOrderDto.setId(purchaseOrder.getId());
        purchaseOrderDto.setCartId(cart.getId());

        return purchaseOrderDto;
    }
}
