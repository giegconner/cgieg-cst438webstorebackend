package edu.csumb.sp19.cst438.webstore.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import edu.csumb.sp19.cst438.webstore.repositories.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import edu.csumb.sp19.cst438.webstore.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products/add")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping("/products/get/{id}")
    public Product getProductById(@PathVariable String id) {
        Product result = productRepository.findByRepoId(id);
        return result;
    }

    @GetMapping("/products/getAll")
    public List<Product> getAllProducts() {
        List<Product> result = productRepository.findAll();
        return result;
    }
}