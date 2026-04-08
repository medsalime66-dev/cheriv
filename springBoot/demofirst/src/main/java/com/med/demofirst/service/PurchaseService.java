package com.med.demofirst.service;

import com.med.demofirst.model.Product;
import com.med.demofirst.model.Purchase;
import com.med.demofirst.repository.ProductRepository;
import com.med.demofirst.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    public Purchase createPurchase(Long productId, int quantity) {

        // prendre le produit
        Optional<Product> productOpt = productRepository.findById(productId);

        if (!productOpt.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        
        Product product = productOpt.get();

        // calculer le total
        double total = product.getPrice() * quantity;

        // créer la purchase
        Purchase purchase = new Purchase();
        purchase.setProduct(product);
        purchase.setQuantity(quantity);
        purchase.setTotalPrice(total);

        return purchaseRepository.save(purchase);
    }
}