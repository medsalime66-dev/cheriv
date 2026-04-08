package com.med.demofirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.med.demofirst.model.Product;

@Repository
public interface ProductRepository 
        extends JpaRepository<Product, Long> {
}