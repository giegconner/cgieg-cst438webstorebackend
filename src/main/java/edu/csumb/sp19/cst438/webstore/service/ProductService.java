package edu.csumb.sp19.cst438.webstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.csumb.sp19.cst438.webstore.model.Product;
import edu.csumb.sp19.cst438.webstore.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Create operation
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //Retrieve operation
    public Product getProductById(String id) {
        return productRepository.findByRepoId(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}