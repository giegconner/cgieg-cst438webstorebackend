package edu.csumb.cst438.webstoredb.service;

import java.util.List;
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
    
    public Product findProductById(String id) {
        return productRepo.findByProductId(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteProductId(String id) {
        productRepo.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepo.deleteAll();
    }
}