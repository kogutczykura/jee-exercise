package com.agata.jeeshop.controllers;

import com.agata.jeeshop.dto.OrderFormDto;
import com.agata.jeeshop.dto.PurchaseOrderDto;
import com.agata.jeeshop.models.PurchaseOrder;
import com.agata.jeeshop.services.CartService;
import com.agata.jeeshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderViewController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ModelAndView getCartView(@PathVariable("id") final long orderId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("orderComplete");
        PurchaseOrderDto order = orderService.getOne(orderId);
        mav.addObject("order", order);
        mav.addObject("cart", cartService.findById(order.getCartId()));
        return mav;
    }

    @GetMapping("/form/{cartId}")
    public ModelAndView getInfoFromForm(@PathVariable("cartId") final long id,
                                        @ModelAttribute @Valid final OrderFormDto orderFormDto,
                                        final BindingResult bindingResulst,
                                        final HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.addObject("orderForm", orderFormDto);

        if(orderFormDto.getEmail() != null && orderFormDto.getLastName() != null && orderFormDto.getFirstName() != null) {
            mav.addObject("errors", bindingResulst.getAllErrors());
        }

        mav.setViewName("inputDataToOrder");

        if(bindingResulst.hasErrors()){
            return mav;
        }

        PurchaseOrderDto dto = orderService.createOrder(id, orderFormDto);
        response.setStatus(HttpServletResponse.SC_SEE_OTHER);
        response.setHeader("Location", "/order/" + dto.getId());

        return mav;
    }
}
