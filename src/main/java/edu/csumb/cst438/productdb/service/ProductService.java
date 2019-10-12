package edu.csumb.cst438.productdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.csumb.cst438.productdb.model.Product;
import edu.csumb.cst438.productdb.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public void addProduct(Product product) {
        productRepo.save(product);
    }
    
    public Product findByProductId(String id) {
        return productRepo.findByRepoId(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}