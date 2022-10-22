package com.codecool.bestevershop.service;

import com.codecool.bestevershop.model.Product;
import com.codecool.bestevershop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
        log.info("Dodano produkt: " + product.getName());
    }

    public void editProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
        log.info("Usunięto produkt o id: " + id);
    }
}
