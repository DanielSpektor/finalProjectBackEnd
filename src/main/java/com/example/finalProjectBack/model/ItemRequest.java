package com.example.finalProjectBack.model;

public class ItemRequest {
    private int itemId;
    private String itemName;
    private int quantity;
    private int price;

    public ItemRequest(int itemId, String itemName, int quantity, int price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Item toItem() {
        return new Item(
                this.itemId,
                this.itemName,
                this.quantity,
                this.price);
    }
}
