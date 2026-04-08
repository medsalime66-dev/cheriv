package com.med.demofirst.controller;

import com.med.demofirst.service.ProductService;
import com.med.demofirst.service.PurchaseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    private final ProductService productService;
    private final PurchaseService purchaseService;

    // Constructor Injection
    public ViewController(ProductService productService,
                          PurchaseService purchaseService) {
        this.productService = productService;
        this.purchaseService = purchaseService;
    }

    // Display the list of products
    @GetMapping("/products")
    public String showProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    // Display the purchase page
    @GetMapping("/purchase")
    public String showPurchasePage(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "purchase";
    }

    // Handle the purchase form submission
    @PostMapping("/purchase")
    public String handlePurchase(@RequestParam Long productId,
                                 @RequestParam int quantity){

        purchaseService.createPurchase(productId, quantity);

        return "redirect:/success";
    }

    // Display success page after purchase
    @GetMapping("/success")
    public String success(){
        return "success";
    }
}