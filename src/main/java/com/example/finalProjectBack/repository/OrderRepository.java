package com.example.finalProjectBack.repository;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUserId(int userId);
    Optional<Order> findById(int orderId);
    Order createOrder(Order order);
    void addItemToOrder(int orderId, Item item);
    ResponseEntity<String> closeOrder(int orderId);


}
