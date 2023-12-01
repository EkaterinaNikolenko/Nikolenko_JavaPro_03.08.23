package edu.hillel.springcore.repository;

import edu.hillel.springcore.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();

    public Product getProductById(int id) {
        return products.get(id);
    }

    public Map<Integer, Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
}
