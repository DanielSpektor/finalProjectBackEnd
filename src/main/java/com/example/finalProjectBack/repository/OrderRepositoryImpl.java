package com.example.finalProjectBack.repository;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.model.Order;
import com.example.finalProjectBack.repository.mapper.ItemMapper;
import com.example.finalProjectBack.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public abstract class OrderRepositoryImpl implements OrderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ORDERS_TABLE_NAME = "order";

    RowMapper<Item> itemMapper = new ItemMapper();

    OrderMapper orderMapper = new OrderMapper(itemMapper);



    @Override
    public List<Order> findByUserId(int userId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE userId = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new OrderMapper(itemMapper));
    }

    @Override
    public Optional<Order> findById(int orderId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE orderId = ?";
        Order order = jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OrderMapper(itemMapper));
        return Optional.ofNullable(order);

    }

    @Override
    public Order createOrder(Order order) {
        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (orderId, userId, orderDate, shippingAddress, totalPrice, status) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getOrderId(), order.getUserId(), order.getOrderDate(), order.getShippingAddress(), order.getTotalPrice(), order.getStatus().toString());
        return order;
    }

    @Override
    public void addItemToOrder(int orderId, Item item) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " WHERE orderId = ? ";
        jdbcTemplate.update(sql, orderId, item);
    }

}
