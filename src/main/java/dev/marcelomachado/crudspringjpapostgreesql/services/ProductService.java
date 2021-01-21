package dev.marcelomachado.crudspringjpapostgreesql.services;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Product;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){

        return repository.findAll();
    }

    public Product FindByID(Integer id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();


    }


}
