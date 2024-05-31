package com.example.client.repositories;

import com.example.client.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientId(Long clientId);

    @Query("SELECT o.product, SUM(o.quantity) FROM Order o GROUP BY o.product ORDER BY SUM(o.quantity) DESC")
    List<Object[]> findMostOrderedProduct();

    @Query("SELECT SUM(o.quantity) FROM Order o WHERE o.product.id = :productId")
    Integer findTotalQuantityOrderedByProductId(Long productId);
}
