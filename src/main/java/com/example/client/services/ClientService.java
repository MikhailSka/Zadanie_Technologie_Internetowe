package com.example.client.services;

import com.example.client.models.Client;
import com.example.client.models.Order;
import com.example.client.repositories.ClientRepository;
import com.example.client.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public long countOrdersByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId).size();
    }

    public double calculateTotalOrderCostByClientId(Long clientId) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        return orders.stream()
                .mapToDouble(order -> order.getQuantity() * order.getProduct().getPrice())
                .sum();
    }
}
