package edu.hillel.springdata;

import edu.hillel.springdata.dao.OrderRepository;
import edu.hillel.springdata.dao.ProductRepository;
import edu.hillel.springdata.dto.Order;
import edu.hillel.springdata.dto.Product;
import edu.hillel.springdata.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDataApplication.class, args);
        OrderService orderService = applicationContext.getBean(OrderService.class);

        Product product1 = new Product("product1", 50.00);
        Product product2 = new Product("product2", 60.00);

        Order order = new Order();
        order.setCost(120.00);
        order.setDate(new Date());
        order.setProducts(List.of(product1, product2));

        orderService.addOrder(order);
        System.out.println(orderService.getAllOrders());
    }

}
