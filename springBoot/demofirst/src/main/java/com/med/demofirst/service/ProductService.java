package com.med.demofirst.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.med.demofirst.model.Product;
import com.med.demofirst.repository.ProductRepository;

@Service
public class ProductService {

@Autowired
private ProductRepository repository;

public List<Product> getAllProducts(){
    return repository.findAll();
}


public Product createProduct(Product product){
    return repository.save(product);
}

}