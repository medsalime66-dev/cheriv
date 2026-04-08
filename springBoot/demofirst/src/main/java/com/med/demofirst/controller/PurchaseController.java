package com.med.demofirst.controller;

import com.med.demofirst.model.Purchase;
import com.med.demofirst.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping
    public Purchase createPurchase(
            @RequestParam Long productId,
            @RequestParam int quantity) {

        return service.createPurchase(productId, quantity);
    }
}