package com.codecool.springdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private final Product product = new Product(BigDecimal.valueOf(23.50));

    private final List<Product> products = Arrays.asList(
            new Product(BigDecimal.valueOf(23.50)),
            new Product(BigDecimal.valueOf(23.50))
    );

    public Product get(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductBeforeDiscount(){
        return product;
    }

    public Product getProductAfterDiscount(){
        //apply discount here
        product.applyDiscount(BigDecimal.valueOf(3));


        throw new IllegalArgumentException("Not Implemented Yet!!!");
    }
}
