package com.agata.jeeshop.services;

import com.agata.jeeshop.dto.OrderFormDto;
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
    public PurchaseOrderDto createOrder(long cartId, OrderFormDto orderFormDto){
        Cart cart;
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();

        cart = cartRepository.getOne(cartId);
        cart.setSold(true);

        purchaseOrder.setCart(cart);
        purchaseOrder.setFirstName(orderFormDto.getFirstName());
        purchaseOrder.setLastName(orderFormDto.getLastName());
        purchaseOrder.setEmail(orderFormDto.getEmail());

        cartRepository.save(cart);
        orderRepository.save(purchaseOrder);

        purchaseOrderDto.setId(purchaseOrder.getId());
        purchaseOrderDto.setCartId(cart.getId());
        purchaseOrderDto.setEmail(purchaseOrder.getEmail());
        purchaseOrderDto.setFirstName(purchaseOrder.getFirstName());
        purchaseOrderDto.setLastName(purchaseOrder.getLastName());

        return purchaseOrderDto;
    }

    public PurchaseOrderDto getOne(long orderId) {
        PurchaseOrder order = orderRepository.getOne(orderId);
        return toDto(order);
    }

    private PurchaseOrderDto toDto(PurchaseOrder purchaseOrder) {
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
        Cart cart = purchaseOrder.getCart();

        purchaseOrderDto.setId(purchaseOrder.getId());
        purchaseOrderDto.setCartId(cart.getId());
        purchaseOrderDto.setEmail(purchaseOrder.getEmail());
        purchaseOrderDto.setFirstName(purchaseOrder.getFirstName());
        purchaseOrderDto.setLastName(purchaseOrder.getLastName());

        return purchaseOrderDto;
    }
}
