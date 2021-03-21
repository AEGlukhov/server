package com.server.models;

public class Product {
    Integer id;
    Integer ownerId;
    String name;
    Integer price;
    String date;
    String photo;

    public Product(Integer id, Integer ownerId, String name, Integer price, String date, String photo) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.price = price;
        this.date = date;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getPhoto() {
        return photo;
    }
}
