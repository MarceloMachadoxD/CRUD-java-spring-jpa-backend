package dev.marcelomachado.crudspringjpapostgreesql.repositories;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}