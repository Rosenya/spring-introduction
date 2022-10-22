package com.codecool.springdependencyinjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product get(Long id);
    Product getProductBeforeDiscount(Long id);
    Product getProductAfterDiscount(Long id);

}
