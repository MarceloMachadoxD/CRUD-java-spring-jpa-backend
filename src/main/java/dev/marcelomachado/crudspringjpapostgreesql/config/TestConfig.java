package dev.marcelomachado.crudspringjpapostgreesql.config;

import dev.marcelomachado.crudspringjpapostgreesql.entities.User;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User user = new User(null, "Maria1", "Maria@em.com", "215553152", "Strong Password hahaha" + String.valueOf(Math.PI));
        User user1 = new User(null, "Fulano", "fulano@xd.com", "2198765432", "WeakPassWord");

        userRepository.saveAll(Arrays.asList(user, user1));

    }
}
