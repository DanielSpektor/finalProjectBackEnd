package com.example.finalProjectBack.service;

import com.example.finalProjectBack.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();
    Item getItemById(int itemId);
    ResponseEntity<String> orderItem(int itemId, int quantity);
    List<Item> findItemsByOrderId(int orderId);
    void updateItemStock(int itemId, int newStock);

}
