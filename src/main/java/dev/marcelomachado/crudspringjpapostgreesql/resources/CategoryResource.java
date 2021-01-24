package dev.marcelomachado.crudspringjpapostgreesql.resources;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Category;
import dev.marcelomachado.crudspringjpapostgreesql.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category obj){
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);

    }

}
