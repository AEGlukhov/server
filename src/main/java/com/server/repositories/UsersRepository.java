package com.server.repositories;

import com.server.mapper.UserMapper;
import com.server.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer addUser(User user){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("INSERT INTO users (name, password, country, money, score, photo)" +
                " VALUES (?, ?, ?, ?, ?, ?)", user.getName(), user.getPassword(), user.getCountry(), user.getMoney(), user.getScore(), user.getPhoto());

    }

    public List<User> getUsers(){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }

    public Integer deleteUser(Integer id){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);

    }

    public Integer changeUser(Integer id, User user){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("UPDATE users SET name = ?, password = ?, country = ?, " +
                " money = ?, score = ?, photo = ? WHERE id = ?", user.getName(), user.getPassword(), user.getCountry(), user.getMoney(), user.getScore(), user.getPhoto(), id);
    }

}
