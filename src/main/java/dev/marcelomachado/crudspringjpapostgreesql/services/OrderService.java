package dev.marcelomachado.crudspringjpapostgreesql.services;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Order;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){

        return repository.findAll();
    }

    public Order FindByID(Integer id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();


    }


}
