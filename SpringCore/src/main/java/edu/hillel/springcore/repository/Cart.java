package edu.hillel.springcore.repository;

import edu.hillel.springcore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Product> cart = new HashMap<>();

    private ProductRepository productRepository;
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Integer, Product> getAllProducts() {
        return cart;
    }

    public void addProduct(int id) {
        Product product = productRepository.getProductById(id);
        cart.put(product.getId(), product);
    }

    public void removeProduct(int id) {
        cart.remove(id);
    }
}
