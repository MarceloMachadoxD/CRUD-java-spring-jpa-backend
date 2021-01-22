package dev.marcelomachado.crudspringjpapostgreesql.repositories;

import dev.marcelomachado.crudspringjpapostgreesql.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}