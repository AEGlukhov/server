package com.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createSchema(){
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS GarbageCollectorDB");
        jdbcTemplate.execute("USE GarbageCollectorDB");
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users " +
                " (id INT AUTO_INCREMENT PRIMARY KEY, " +
                " name VARCHAR(50), " +
                " password VARCHAR(50), " +
                " country VARCHAR(50), " +
                " money INT, " +
                " score INT, " +
                " photo INT )");
        jdbcTemplate.execute("DROP TABLE IF EXISTS places");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS places " +
                " (id INT AUTO_INCREMENT PRIMARY KEY, " +
                " ownerId INT, " +
                " cleanerId INT, " +
                " address VARCHAR(100), " +
                " date VARCHAR(50), " +
                " photo VARCHAR(100), " +
                " lat DOUBLE, " + " lon DOUBLE, " +
                " proof VARCHAR(100) )");
        jdbcTemplate.execute("DROP TABLE IF EXISTS products");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS products " +
                " (id INT AUTO_INCREMENT PRIMARY KEY, " +
                " ownerId INT, " +
                " name VARCHAR(50), " +
                " price INT, " +
                " date VARCHAR(50), " +
                " photo VARCHAR(100) )");

        return  "created";
    }
}
