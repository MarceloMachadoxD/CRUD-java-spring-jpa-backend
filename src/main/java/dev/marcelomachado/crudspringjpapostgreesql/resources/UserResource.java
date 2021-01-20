package dev.marcelomachado.crudspringjpapostgreesql.resources;

import dev.marcelomachado.crudspringjpapostgreesql.entities.User;
import dev.marcelomachado.crudspringjpapostgreesql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> FindByID(@PathVariable Long id) {
        User user = service.FindByID(id);
        return ResponseEntity.ok().body(user);
    }

}
