package dev.marcelomachado.crudspringjpapostgreesql.services;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Category;
import dev.marcelomachado.crudspringjpapostgreesql.entities.User;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){

        return repository.findAll();
    }

    public Category FindByID(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();


    }

    public Category insert(Category obj){
        return repository.save(obj);

    }

}
