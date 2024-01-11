package com.hillel.edu.springsecurity.controller;

import com.hillel.edu.springsecurity.model.Product;
import com.hillel.edu.springsecurity.repository.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository repository;
    private static final Logger logger = Logger.getLogger(ProductController.class);

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        logger.info("Receiving product by id");
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        logger.info("Receiving all products");
        return repository.findAll();
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        logger.info("Saving product");
        return repository.save(product);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product by id");
        repository.deleteById(id);
    }
}
