package com.example.client.services;

import com.example.client.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private OrderRepository orderRepository;

    public Object[] getMostOrderedProduct() {
        return orderRepository.findMostOrderedProduct().stream().findFirst().orElse(null);
    }

    public int getTotalQuantityOrderedByProductId(Long productId) {
        return orderRepository.findTotalQuantityOrderedByProductId(productId);
    }
}
