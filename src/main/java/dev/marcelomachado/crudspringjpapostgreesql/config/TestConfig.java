package dev.marcelomachado.crudspringjpapostgreesql.config;

import dev.marcelomachado.crudspringjpapostgreesql.entities.Category;
import dev.marcelomachado.crudspringjpapostgreesql.entities.Order;
import dev.marcelomachado.crudspringjpapostgreesql.entities.Product;
import dev.marcelomachado.crudspringjpapostgreesql.entities.User;
import dev.marcelomachado.crudspringjpapostgreesql.entities.enums.OrderStatus;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.CategoryRepository;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.OrderRepository;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.ProductRepository;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User(null, "Maria1", "Maria@em.com", "215553152", "Strong Password hahaha" + String.valueOf(Math.PI));
        User user1 = new User(null, "Fulano", "fulano@xd.com", "2198765432", "WeakPassWord");
        User user2 = new User(null, "Beltrano", "Maria@em.com", "215553152", "Strong Password hahaha" + String.valueOf(Math.PI));


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);


        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "fellowship", 90.5, "");
        Product p2 = new Product(null, "SmartTV", "Nada", 2190.5, "");
        Product p3 = new Product(null, "Macbook Pro", "Nada", 1250.5, "");
        Product p4 = new Product(null, "PC Gamer", "Nada", 1200.5, "");
        Product p5 = new Product(null, "Use a cabeça JAVA", "Nada", 100.5, "");

        userRepository.saveAll(Arrays.asList(user, user1, user2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }


}
