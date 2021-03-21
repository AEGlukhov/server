package com.server.services;

import com.server.models.Place;
import com.server.models.Product;
import com.server.models.User;
import com.server.repositories.DefaultRepository;
import com.server.repositories.PlacesRepository;
import com.server.repositories.ProductsRepository;
import com.server.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultService {
    @Autowired
    DefaultRepository defaultRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    ProductsRepository productsRepository;

    public Integer addUser(User user){
        return usersRepository.addUser(user);
    }

    public List<User> getUsers(){
        return usersRepository.getUsers();
    }




    public Integer addPlace(Place place){
        return  placesRepository.addPlace(place);
    }

    public List<Place> getPlaces(){
        return placesRepository.getPlaces();
    }


    public Integer addProduct(Product product) { return  productsRepository.addProduct(product);}

    public List<Product> getProducts() { return  productsRepository.getProducts();}

    public String createSchema(){
        return defaultRepository.createSchema();
    }

    public Integer deleteUser(Integer id){
        return usersRepository.deleteUser(id);
    }
    public Integer deleteProduct(Integer id){
        return productsRepository.deleteProduct(id);
    }

    public Integer deletePlace(Integer id){
        return placesRepository.deletePlace(id);
    }

    public Integer changeUser(Integer id, User user){
        return usersRepository.changeUser(id, user);
    }

    public Integer changePlace(Integer id, Place place){
        return placesRepository.changePlace(id, place);
    }


}
