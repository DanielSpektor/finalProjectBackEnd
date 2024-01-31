package com.example.finalProjectBack.service;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.model.Order;
import com.example.finalProjectBack.model.OrderRequest;
import com.example.finalProjectBack.model.OrderStatus;
import com.example.finalProjectBack.repository.OrderRepository;
import com.example.finalProjectBack.utils.OrderNotFoundException;
import com.example.finalProjectBack.utils.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Optional<Order> findById(int orderId) {
        return null;
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
       return orderRepository.createOrder(orderRequest.toOrder());
    }

    @Override
    public ResponseEntity<String> closeOrder(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            if(order.getStatus() == OrderStatus.TEMP) {
                order.setStatus(OrderStatus.CLOSE);
                orderRepository.createOrder(order);
                return ResponseEntity.ok("Order closed successfully");
            } else {
                return ResponseEntity.badRequest().body("Invalid order or already closed");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void addItemToOrder(int userId, int orderId, List<Item> items) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        if (order.getUserId() != userId) {
            throw new UnauthorizedException("User is not authorized to modify this order");
        }
        order.getItems().addAll(items);
        orderRepository.save(order);
    }

}
