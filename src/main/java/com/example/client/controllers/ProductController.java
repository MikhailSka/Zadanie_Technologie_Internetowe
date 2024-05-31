package com.example.client.controllers;

import com.example.client.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/most-ordered")
    public Object[] getMostOrderedProduct() {
        return productService.getMostOrderedProduct();
    }

    @GetMapping("/{id}/total-quantity")
    public int getTotalQuantityOrderedByProductId(@PathVariable Long id) {
        return productService.getTotalQuantityOrderedByProductId(id);
    }
}
