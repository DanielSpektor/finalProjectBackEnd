package com.example.finalProjectBack.repository;

import com.example.finalProjectBack.model.Item;
import com.example.finalProjectBack.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ItemRepositoryImpl implements ItemRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String ITEMS_TABLE_NAME = "items";


    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEMS_TABLE_NAME;
        return jdbcTemplate.query(sql, new ItemMapper());
    }

    @Override
    public Item getItemById(int itemId) {
        String sql = "SELECT * FROM " + ITEMS_TABLE_NAME + " WHERE itemId = ?";
        return jdbcTemplate.queryForObject(sql, new ItemMapper(), itemId);
    }

    @Override
    public ResponseEntity<String> orderItem(int itemId, int quantity) {
        return null;
    }

    @Override
    public List<Item> findItemsByOrderId(int orderId) {
        String sql = "SELECT * FROM " + ITEMS_TABLE_NAME + " WHERE order_id = ?";
        return jdbcTemplate.query(sql, new ItemMapper(), orderId);
    }

    @Override
    public void updateItemStock(int itemId, int quantity) {
        String sql = "UPDATE " + ITEMS_TABLE_NAME + " SET quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql, quantity, itemId);
    }
}
