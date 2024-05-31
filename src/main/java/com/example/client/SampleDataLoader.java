package com.example.client;

import com.example.client.models.Client;
import com.example.client.models.Product;
import com.example.client.models.Order;
import com.example.client.repositories.ClientRepository;
import com.example.client.repositories.ProductRepository;
import com.example.client.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public SampleDataLoader(ClientRepository clientRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Clients
        Client client1 = new Client();
        client1.setFirstName("John");
        client1.setLastName("Doe");
        client1.setEmail("john.doe@example.com");
        client1.setPhoneNumber("1234567890");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setFirstName("Jane");
        client2.setLastName("Doe");
        client2.setEmail("jane.doe@example.com");
        client2.setPhoneNumber("0987654321");
        clientRepository.save(client2);

        // Create Products
        Product product1 = new Product();
        product1.setName("Product A");
        product1.setDescription("Description of Product A");
        product1.setPrice(10.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product B");
        product2.setDescription("Description of Product B");
        product2.setPrice(20.0);
        productRepository.save(product2);

        // Create Orders
        Order order1 = new Order();
        order1.setOrderDate(LocalDate.now());
        order1.setClient(client1);
        order1.setProduct(product1);
        order1.setQuantity(2);
        orderRepository.save(order1);

        Order order2 = new Order();
        order2.setOrderDate(LocalDate.now());
        order2.setClient(client2);
        order2.setProduct(product2);
        order2.setQuantity(1);
        orderRepository.save(order2);
    }
}
