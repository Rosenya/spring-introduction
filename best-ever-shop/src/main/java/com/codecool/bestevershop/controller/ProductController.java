package com.codecool.bestevershop.controller;

import com.codecool.bestevershop.model.Product;
import com.codecool.bestevershop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getProduct(@PathVariable(required = false, name="productID") Long id){
        if(id == null){
            return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
        }
        Product product = productService.getProduct(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity editProduct(@RequestBody Product product, @PathVariable Long id){
        productService.editProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@RequestParam("id") Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok(null);
    }
}
