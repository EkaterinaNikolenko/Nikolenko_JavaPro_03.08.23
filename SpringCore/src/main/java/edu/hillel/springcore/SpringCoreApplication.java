package edu.hillel.springcore;

import edu.hillel.springcore.model.Product;
import edu.hillel.springcore.repository.Cart;
import edu.hillel.springcore.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreApplication.class, args);

        final ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        productRepository.addProduct(new Product(1, "smartphone", 800.00));
        productRepository.addProduct(new Product(2,"laptop", 1250.00));
        productRepository.addProduct(new Product(3, "headphones", 125.00));
        System.out.println(productRepository.getProductById(1));
        System.out.println(productRepository.getAllProducts());

        final Cart cart = applicationContext.getBean(Cart.class);
        cart.addProduct(1);
        cart.addProduct(2);
        System.out.println(cart.getAllProducts());
        cart.removeProduct(2);
        System.out.println(cart.getAllProducts());

        final Cart cart1 = applicationContext.getBean(Cart.class);
        final Cart cart2 = applicationContext.getBean(Cart.class);
        System.out.println(cart1.equals(cart2));
    }

}
