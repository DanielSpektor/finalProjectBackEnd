package com.example.finalProjectBack.model;

public class OrderRequest {

    private int itemId;
    private String itemName;
    private int itemPrice;

    public OrderRequest(int itemId, String itemName, int itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Order toOrder() {
        return new Order(
                toOrder().getUserId(),
                toOrder().getOrderId(),
                toOrder().getOrderDate(),
                "",
                toOrder().getTotalPrice(),
                toOrder().getStatus(),
                toOrder().getItems()
        );
    }
};
