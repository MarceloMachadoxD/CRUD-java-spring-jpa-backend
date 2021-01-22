package dev.marcelomachado.crudspringjpapostgreesql.config;

import dev.marcelomachado.crudspringjpapostgreesql.entities.*;
import dev.marcelomachado.crudspringjpapostgreesql.entities.enums.OrderStatus;
import dev.marcelomachado.crudspringjpapostgreesql.repositories.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "fellowship", 90.5, "");
        Product p2 = new Product(null, "SmartTV", "Nada", 2190.5, "");
        Product p3 = new Product(null, "Macbook Pro", "Nada", 1250.5, "");
        Product p4 = new Product(null, "PC Gamer", "Nada", 1200.5, "");
        Product p5 = new Product(null, "Use a cabeça JAVA", "Nada", 100.5, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User user = new User(null, "Maria1", "Maria@em.com", "215553152", "Strong Password hahaha" + String.valueOf(Math.PI));
        User user1 = new User(null, "Fulano", "fulano@xd.com", "2198765432", "WeakPassWord");
        User user2 = new User(null, "Beltrano", "Maria@em.com", "215553152", "Strong Password hahaha" + String.valueOf(Math.PI));


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);


        userRepository.saveAll(Arrays.asList(user, user1, user2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));


    }


}
