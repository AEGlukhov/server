package com.server.repositories;

import com.server.mapper.PlaceMapper;
import com.server.models.Place;
import com.server.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlacesRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public Integer addPlace(Place place){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("INSERT INTO places (ownerId, cleanerId, address, date, photo, lat, lon, proof)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                place.getOwnerId(),
                place.getCleanerId(),
                place.getAddress(),
                place.getDate(),
                place.getPhoto(),
                place.getLat(),
                place.getLon(),
                place.getProof());
    }

    public List<Place> getPlaces(){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.query("SELECT * FROM places", new PlaceMapper());
    }

    public Integer deletePlace(Integer id){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("DELETE FROM places WHERE id = ?", id);

    }

    public Integer changePlace(Integer id, Place place){
        jdbcTemplate.execute("USE GarbageCollectorDB");
        return jdbcTemplate.update("UPDATE places SET ownerId = ?, cleanerId = ?, address = ?, " +
                " date = ?, photo = ?, lat = ?, lon = ?, proof = ? WHERE id = ?", place.getOwnerId(),
                place.getCleanerId(),
                place.getAddress(),
                place.getDate(),
                place.getPhoto(),
                place.getLat(),
                place.getLon(),
                place.getProof(), id);
    }
}
