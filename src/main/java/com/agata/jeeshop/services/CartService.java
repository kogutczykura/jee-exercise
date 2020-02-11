package com.agata.jeeshop.services;

import com.agata.jeeshop.dto.AddProductToCartRequest;
import com.agata.jeeshop.dto.CartDto;
import com.agata.jeeshop.dto.CartItemDto;
import com.agata.jeeshop.dto.ProductDto;
import com.agata.jeeshop.mappers.CartMapper;
import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.CartItem;
import com.agata.jeeshop.models.Product;
import com.agata.jeeshop.respositories.CartItemRepository;
import com.agata.jeeshop.respositories.CartRepository;
import com.agata.jeeshop.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartItemRepository cartItemRepository;


    public CartDto findById(long id) {
        if (id == 0) {
            return null;
        }

        Optional<Cart> cartOptional = cartRepository.findById(id);
        Cart cart = cartOptional.orElse(null);

        return cartMapper.toDto(cart);
    }

    public CartDto addToCart(AddProductToCartRequest addProductToCartRequest) {
        Cart cart;
        if (addProductToCartRequest.getCartId() == 0) {
            cart = new Cart();
        } else {
            cart = cartRepository.getOne(addProductToCartRequest.getCartId());
        }

        Product product = productRepository.getOne(addProductToCartRequest.getProductId());
        CartItem cartItem = new CartItem();

        cartItem.setProductId(product.getId());
        cartItem.setProductName(product.getName());
        cartItem.setProductPrice(product.getPrice());
        cartItem.setCart(cart);

        cart.getItems().add(cartItem);

        cartRepository.save(cart);
        cartItemRepository.save(cartItem);

        return cartMapper.toDto(cart);
    }

    public String calculateTotalAmount(Long id) {

        CartDto cartDto = this.findById(id);
        Double totalAmount = 0.;
        if(cartDto == null)
        {
            return String.format("%.2f", 0.0);
        }
        for (CartItemDto cartItem : cartDto.getItems()
        ) {
            totalAmount += cartItem.getProductPrice();
        }
        this.findById(id).setTotalAmount(totalAmount);


        return String.format("%.2f", totalAmount);
    }

    public void removeProduct(Long cartId, Long id) {
        Cart cart = cartRepository.getOne(cartId);
        for (CartItem item : cart.getItems()) {
            if (item.getId() == id){
                cartItemRepository.delete(item);
                break;
            }
        }
      //  throw new RuntimeException("Cart item with id: " + cart.getItems() + " not found");
    }
}