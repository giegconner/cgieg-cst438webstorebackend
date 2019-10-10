package edu.csumb.sp19.cst438.webstore.service;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import edu.csumb.sp19.cst438.webstore.repositories.ProductRepository;
import edu.csumb.sp19.cst438.webstore.model.Product;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDbSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("iPhone X", "An amazing smartphone that came out two years ago.",
        "http://t0.gstatic.com/images?q=tbn%3AANd9GcRW8XGcOjxKXwaSac9DZBorKNmorXylD6FBXD-hadNmP65I2PoLeIm6qW0B&usqp=CAc",
        534.00, 5);
        Product product2 = new Product("OnePlus 7 Pro", "A 90Hz refresh rate display smartphone",
        "http://t0.gstatic.com/images?q=tbn%3AANd9GcQbIAnuHoWuN67wCNS8RDePsu6mk2fDrP5ODPVKS3lowlt7nv9MVGBYN69SB_pmOJa9PLMXAJaT&usqp=CAc",
        769.00, 10);
        Product product3 = new Product("Galaxy Note10", "A modern smartphone with a stylus",
        "http://t0.gstatic.com/images?q=tbn%3AANd9GcRqk49tDFrQ6KhiXnTiOhDvfq3KSUttG9zkYvMQxamitkrOEQhN9i6tYqknXvBv4Egx8fo8HQ&usqp=CAc",
        949.99, 15);
        //delete db data
        productRepository.deleteAll();
        //add db seeds
        List<Product> products = Arrays.asList(product1, product2, product3);
        productRepository.saveAll(products);
    }
}