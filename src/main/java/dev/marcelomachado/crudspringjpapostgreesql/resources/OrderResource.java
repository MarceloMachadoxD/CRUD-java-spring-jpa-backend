package dev.marcelomachado.crudspringjpapostgreesql.resources;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Order;
import dev.marcelomachado.crudspringjpapostgreesql.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orderList = service.findAll();
        return ResponseEntity.ok().body(orderList);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> FindByID(@PathVariable Integer id) {
        Order ord = service.FindByID(id);
        return ResponseEntity.ok().body(ord);
    }

}
