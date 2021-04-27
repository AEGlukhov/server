package com.server.controllers;

import com.server.models.Place;
import com.server.models.Product;
import com.server.models.User;
import com.server.repositories.DefaultRepository;
import com.server.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    DefaultService defaultService;

    @ResponseBody
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return defaultService.getUsers();
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public Integer addUser(@RequestParam(value = "name") String name,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "country") String country,
                           @RequestParam(value = "money") Integer money,
                           @RequestParam(value = "score") Integer score,
                           @RequestParam(value = "photo") String photo) {
        User user = new User(0, name, password, country, money, score, photo);
        return defaultService.addUser(user);
    }

    @ResponseBody
    @RequestMapping("/getPlaces")
    public List<Place> getPlaces() {
        return defaultService.getPlaces();
    }

    @ResponseBody
    @RequestMapping("/addPlace")
    public Integer addPlace(@RequestParam(value = "ownerId") Integer ownerId,
                            @RequestParam(value = "cleanerId") Integer cleanerId,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "date") String date,
                            @RequestParam(value = "photo") String photo,
                            @RequestParam(value = "lat") Double lat,
                            @RequestParam(value = "lon") Double lon,
                            @RequestParam(value = "proof") String proof) {
        Place place = new Place(0, ownerId, cleanerId, address, date, photo, lat, lon, proof);
        return defaultService.addPlace(place);
    }

    @ResponseBody
    @RequestMapping("/getProducts")
    public List<Product> getProducts() {
        return defaultService.getProducts();
    }

    @ResponseBody
    @RequestMapping("/addProduct")
    public Integer addProduct(@RequestParam(value = "ownerId") Integer ownerId,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "price") Integer price,
                              @RequestParam(value = "date") String date,
                              @RequestParam(value = "photo") String photo) {
        Product product = new Product(0, ownerId, name, price, date, photo);
        return defaultService.addProduct(product);
    }


    @ResponseBody
    @RequestMapping("/createSchema")
    public String createSchema() {
        return defaultService.createSchema();

    }


    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "Test";
    }


    @ResponseBody
    @RequestMapping("/deleteUser")
    public Integer deleteUser(@RequestParam(value = "id") Integer id) {
        return defaultService.deleteUser(id);
    }

    @ResponseBody
    @RequestMapping("/deleteProduct")
    public Integer deleteProduct(@RequestParam(value = "id") Integer id) {
        return defaultService.deleteProduct(id);
    }

    @ResponseBody
    @RequestMapping("/deletePlace")
    public Integer deletePlace(@RequestParam(value = "id") Integer id) {
        return defaultService.deletePlace(id);
    }

    @ResponseBody
    @RequestMapping("/changeUser")
    public Integer changeUser(@RequestParam(value = "id") Integer id,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "country") String country,
                              @RequestParam(value = "money") Integer money,
                              @RequestParam(value = "score") Integer score,
                              @RequestParam(value = "photo") String photo) {
        User user = new User(0, name, password, country, money, score, photo);
        return defaultService.changeUser(id, user);
    }

    @ResponseBody
    @RequestMapping("/changePlace")
    public Integer changePlace(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "ownerId") Integer ownerId,
                               @RequestParam(value = "cleanerId") Integer cleanerId,
                               @RequestParam(value = "address") String address,
                               @RequestParam(value = "date") String date,
                               @RequestParam(value = "photo") String photo,
                               @RequestParam(value = "lat") Double lat,
                               @RequestParam(value = "lon") Double lon,
                               @RequestParam(value = "proof") String proof) {
        Place place = new Place(0, ownerId, cleanerId, address, date, photo, lat, lon, proof);
        return defaultService.changePlace(id, place);
    }


}
