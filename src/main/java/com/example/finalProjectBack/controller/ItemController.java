package com.example.finalProjectBack.controller;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/public/items")
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping(value = "/allItems")
    @CrossOrigin
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/items/{itemId}")
    @CrossOrigin
    public String getItemById(@PathVariable int itemId) {
        Optional<Item> itemOptional = Optional.ofNullable(itemService.getItemById(itemId));
        if(itemOptional.isPresent()) {
            Item item = itemOptional.get();
            return "Item found : " +item.getItemName();
        } else {
            return "Item Not Found";
        }
    }
    @GetMapping(value = "/orders/{orderId}/items")
    @CrossOrigin
    public List<Item> findItemsByOrderId(@PathVariable int orderId) {
        return itemService.findItemsByOrderId(orderId);
    }

    @PostMapping(value = "/orderItem")
    @CrossOrigin
    public ResponseEntity<String> orderItem(@RequestParam int itemId, @RequestParam int quantity) {
        return itemService.orderItem(itemId, quantity);
    }

}
