package dev.marcelomachado.crudspringjpapostgreesql.resources;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Category;
import dev.marcelomachado.crudspringjpapostgreesql.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> CategoryList = service.findAll();
        return ResponseEntity.ok().body(CategoryList);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> FindByID(@PathVariable Long id) {
        Category Category = service.FindByID(id);
        return ResponseEntity.ok().body(Category);
    }

}
