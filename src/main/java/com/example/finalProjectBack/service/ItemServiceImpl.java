package com.example.finalProjectBack.service;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @Override
    public Item getItemById(int itemId) {
        return itemRepository.getItemById(itemId);
    }

    @Override
    public List<Item> findItemsByOrderId(int orderId) {
        return itemRepository.findItemsByOrderId(orderId);
    }

    @Override
    public void updateItemStock(int itemId, int newStock) {
        itemRepository.updateItemStock(itemId, newStock);
    }

    @Override
    public ResponseEntity<String> orderItem(int itemId, int quantity) {
        Item item = itemRepository.getItemById(itemId);

        if(item != null && item.getQuantity() >= quantity) {
            int newQuantity = item.getQuantity() - quantity;
            itemRepository.updateItemStock(itemId, quantity);
            return ResponseEntity.ok("Item ordered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item is out of stock");
        }
    }
}
