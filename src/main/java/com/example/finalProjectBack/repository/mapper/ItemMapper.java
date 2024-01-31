package com.example.finalProjectBack.repository.mapper;

import com.example.finalProjectBack.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("itemId"));
        item.setItemName(rs.getString("itemName"));
        item.setQuantity(rs.getInt("quantity"));
        item.setPrice(rs.getInt("price"));
        return item;
    }
}
