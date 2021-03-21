package com.server.mapper;

import com.server.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id;
        Integer ownerId;
        String name;
        Integer price;
        String date;
        String photo;
        id = resultSet.getInt("id");
        ownerId = resultSet.getInt("ownerId");
        name = resultSet.getString("name");
        price = resultSet.getInt("price");
        date = resultSet.getString("date");
        photo = resultSet.getString("photo");
        Product product = new Product(id, ownerId, name, price, date, photo);
        return product;
    }
}
