package com.server.mapper;

import com.server.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id;
        String name;
        String password;
        String country;
        Integer money;
        Integer score;
        Integer photo;
        id = resultSet.getInt("id");
        name = resultSet.getString("name");
        password = resultSet.getString("password");
        country = resultSet.getString("country");
        money = resultSet.getInt("money");
        score = resultSet.getInt("score");
        photo = resultSet.getInt("photo");
        User user = new User(id, name, password, country, money, score, photo);
        return user;
    }
}
