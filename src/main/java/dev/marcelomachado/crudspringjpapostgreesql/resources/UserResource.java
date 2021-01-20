package dev.marcelomachado.crudspringjpapostgreesql.resources;

import dev.marcelomachado.crudspringjpapostgreesql.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
     User user = new User(1L,"Maria1", "Maria@em.com", "215553152", "Strong Password hahaha" + String.valueOf(Math.PI) );
    return ResponseEntity.ok().body(user);
    }





}
