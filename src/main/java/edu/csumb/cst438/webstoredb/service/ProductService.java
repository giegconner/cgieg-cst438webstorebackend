package edu.csumb.cst438.webstoredb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.csumb.cst438.webstoredb.model.Product;
import edu.csumb.cst438.webstoredb.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public void addProduct(Product product) {
        productRepo.save(product);
    }
    
    public Optional<Product> findProductById(String id) {
        return productRepo.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteAllProducts() {
        productRepo.deleteAll();
    }
}