package dev.marcelomachado.crudspringjpapostgreesql.repositories;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}