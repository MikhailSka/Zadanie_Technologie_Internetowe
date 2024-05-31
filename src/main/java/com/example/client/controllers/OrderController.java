package com.example.client.controllers;

import com.example.client.models.Order;
import com.example.client.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Order> getOrdersByClientId(@PathVariable Long clientId) {
        return orderService.getOrdersByClientId(clientId);
    }
}
