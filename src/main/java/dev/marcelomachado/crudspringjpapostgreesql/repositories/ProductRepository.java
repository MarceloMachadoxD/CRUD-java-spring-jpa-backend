package dev.marcelomachado.crudspringjpapostgreesql.repositories;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}