package com.med.demofirst.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.med.demofirst.model.Product;
import com.med.demofirst.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll(){
        return service.getAllProducts();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return service.createProduct(product);
    }

}