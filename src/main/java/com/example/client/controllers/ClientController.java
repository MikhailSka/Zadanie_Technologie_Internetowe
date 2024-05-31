package com.example.client.controllers;

import com.example.client.models.Client;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/{id}/orders/count")
    public long countOrdersByClientId(@PathVariable Long id) {
        return clientService.countOrdersByClientId(id);
    }

    @GetMapping("/{id}/orders/total-cost")
    public double calculateTotalOrderCostByClientId(@PathVariable Long id) {
        return clientService.calculateTotalOrderCostByClientId(id);
    }
}
