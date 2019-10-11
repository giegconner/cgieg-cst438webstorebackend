package edu.csumb.sp19.cst438.webstore;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.sp19.cst438.webstore.model.Product;
import edu.csumb.sp19.cst438.webstore.repositories.ProductRepository;

@Component
public class ProductDbSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("Product Name", "Product Description", "Product Image URL",
        0.0, 0);
        Product p2 = new Product("Product Name", "Product Description", "Product Image URL",
        0.0, 0);
        Product p3 = new Product("Product Name", "Product Description", "Product Image URL",
        0.0, 0);
        //delete db data
        productRepository.deleteAll();
        //add db seeds
        List<Product> products = Arrays.asList(p1, p2, p3);
        productRepository.saveAll(products);
    }
}