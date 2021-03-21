package com.server.repositories;

import com.server.mapper.PlaceMapper;
import com.server.mapper.ProductMapper;
import com.server.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer addProduct(Product product){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("INSERT INTO products (ownerId, name, price, date, photo)" +
                " VALUES (?, ?, ?, ?, ?)",
                product.getOwnerId(),
                product.getName(),
                product.getPrice(),
                product.getDate(),
                product.getPhoto());
    }

    public List<Product> getProducts(){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.query("SELECT * FROM products", new ProductMapper());
    }
    public Integer deleteProduct(Integer id){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);

    }
}
