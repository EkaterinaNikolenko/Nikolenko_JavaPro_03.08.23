package com.hillel.edu.springsecurity.service;

import com.hillel.edu.springsecurity.controller.ProductController;
import com.hillel.edu.springsecurity.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public final ProductController productController;

    public ProductService(ProductController productController) {
        this.productController = productController;
    }

    public Optional<Product> getProduct(Long id) {
        return Optional.ofNullable(productController.getProduct(id));
    }

    public List<Product> getAllProducts() {
        return productController.getAllProducts();
    }

    public Product saveProduct(Product product) {
        return productController.saveProduct(product);
    }

    public void deleteProduct(Long id) {
        productController.deleteProduct(id);
    }
}
