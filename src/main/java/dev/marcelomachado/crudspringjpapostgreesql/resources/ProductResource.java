package dev.marcelomachado.crudspringjpapostgreesql.resources;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Product;
import dev.marcelomachado.crudspringjpapostgreesql.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> ProductList = service.findAll();
        return ResponseEntity.ok().body(ProductList);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> FindByID(@PathVariable Integer id) {
        Product Product = service.FindByID(id);
        return ResponseEntity.ok().body(Product);
    }

}
