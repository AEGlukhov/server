package com.server.mapper;

import com.server.models.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceMapper implements RowMapper<Place> {
    @Override
    public Place mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id;
        Integer ownerId;
        Integer cleanerId;
        String address;
        String date;
        String photo;
        Double lat;
        Double lon;
        String proof;
        id = resultSet.getInt("id");
        ownerId = resultSet.getInt("ownerId");
        cleanerId = resultSet.getInt("cleanerId");
        address = resultSet.getString("address");
        date = resultSet.getString("date");
        photo = resultSet.getString("photo");
        lat = resultSet.getDouble("lat");
        lon = resultSet.getDouble("lon");
        proof = resultSet.getString("proof");
        Place place = new Place(id, ownerId, cleanerId, address, date, photo, lat, lon, proof);
        return place;
    }
}
