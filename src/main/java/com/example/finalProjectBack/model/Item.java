package com.example.finalProjectBack.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int quantity;
    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders;

    public Item() {
    }

    public Item(int itemId, String itemName,int quantity, int price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = 10;
        this.price = price;
    }


    public int getItemId() {
        return itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPrice() {
        return price;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
