package com.agata.jeeshop.services;

import com.agata.jeeshop.dto.ProductDto;
import com.agata.jeeshop.mappers.ProductMapper;
import com.agata.jeeshop.models.Product;
import com.agata.jeeshop.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto findById(Long id) {
        return productMapper.toDto(productRepository.getOne(id));
    }

    public List<ProductDto> findAll(){

        List<Product> listOfProducts = productRepository.findAll();
        List<ProductDto> listOfProductsDto = new ArrayList<>();

       for(Product product : listOfProducts) {
           listOfProductsDto.add(productMapper.toDto(product));
        }
        return listOfProductsDto;
    }

    public ProductDto addProductDto(ProductDto productDto) {
        Product product = productRepository.save(productMapper.fromDto(productDto));
        return productMapper.toDto(product);

    }


}

//        return productRepository
//                .findAll()
//                .stream()
//                .filter(product -> product.getId() % 2 != 0)
//                .collect(Collectors.toList());

//        // Sposób 1
//        List<Product> products = productRepository.findAll();
//        products.removeIf((product) -> product.getId() % 2 != 0);
//        return products;

//        // Sposób 2
//        List<Product> listOfProducts = productRepository.findAll();
//        List<Product> filtered = new ArrayList<>();
//
//        for(int i=0; i<listOfProducts.size(); i++) {
//            if(listOfProducts.get(i).getId()%2==0) {
//                filtered.add(listOfProducts.get(i));
//            }
//        }
//        return filtered;