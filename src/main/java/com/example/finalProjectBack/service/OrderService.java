package com.example.finalProjectBack.service;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.model.Order;
import com.example.finalProjectBack.model.OrderRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findByUserId(int userId);
    Optional<Order> findById(int orderId);
    Order createOrder(OrderRequest orderRequest);
    ResponseEntity<String> closeOrder(int orderId);
    void addItemToOrder(int userId, int orderId, List<Item> items);

}
