package dev.marcelomachado.crudspringjpapostgreesql.repositories;

import dev.marcelomachado.crudspringjpapostgreesql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}