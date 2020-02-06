package com.agata.jeeshop.controllers;

import com.agata.jeeshop.dto.ProductDto;
import com.agata.jeeshop.models.Product;
import com.agata.jeeshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/rest/products")
public class RestAdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> addProducts(@RequestBody ProductDto productDto){
        ProductDto created = productService.addProductDto(productDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


}
