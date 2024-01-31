package com.example.finalProjectBack.repository.mapper;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.model.Order;
import com.example.finalProjectBack.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements RowMapper<Order> {

    private final RowMapper<Item> itemMapper;

    public OrderMapper(RowMapper<Item> itemMapper) {
        this.itemMapper = itemMapper;
    }


    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setUserId(rs.getInt("user_id"));
        order.setOrderDate(rs.getDate("order_date"));
        order.setShippingAddress(rs.getString("shipping_address"));
        order.setTotalPrice(rs.getDouble("total_price"));
        order.setStatus(OrderStatus.valueOf(rs.getString("status")));

        List<Item> items = mapItems(rs); // Implement this method to map items from the ResultSet
        order.setItems(items);

        return order;
    }

    private List<Item> mapItems(ResultSet rs) throws SQLException {
        List<Item> items = new ArrayList<>();
        while (rs.next()) {
            Item item = itemMapper.mapRow(rs, rs.getRow());
            items.add(item);
        }
        return items;
    }
}
