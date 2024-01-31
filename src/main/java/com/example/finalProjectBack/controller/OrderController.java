package com.example.finalProjectBack.controller;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.model.Order;
import com.example.finalProjectBack.model.OrderRequest;
import com.example.finalProjectBack.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/public/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @CrossOrigin
    @PostMapping(value = "/open")
    public ResponseEntity<?> openOrder(@RequestBody OrderRequest orderRequest) {
        try {
            orderService.createOrder(orderRequest);
            return null;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{orderId}/addItems")
    public ResponseEntity<String> addItemToOrder(@PathVariable int orderId, @RequestBody List<Item> items, @RequestParam int userId) {
        try {
            orderService.addItemToOrder(userId, orderId, items);
            return ResponseEntity.ok("Item added to order successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping(value = "/close")
    public ResponseEntity<String> closeOrder(@RequestParam int orderId) {
        orderService.closeOrder(orderId);
        return ResponseEntity.ok("Order closed successfully");
    }

    @GetMapping(value = "/current")
    public ResponseEntity<Optional<Order>> findById(int orderId) {
        Optional<Order> currentOrder = orderService.findById(orderId);

        if (currentOrder.isPresent()) {
            return ResponseEntity.ok(currentOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
