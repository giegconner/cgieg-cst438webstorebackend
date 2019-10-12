package edu.csumb.cst438.productdb;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import edu.csumb.cst438.productdb.model.Product;
import edu.csumb.cst438.productdb.repositories.ProductRepository;

@Component
public class ProductDbSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepo;

    @Override
    public void run(String... args) throws Exception {
        /*Hero ironMan = new Hero(new Identity("Tony Stark"), new AlterEgo("Iron Man"), new Powers(Arrays.asList("energy beams","flight")));
        Hero hulk = new Hero(new Identity("Bruce Banner"), new AlterEgo("The Hulk"), new Powers(Arrays.asList("super strength")));
        Hero spiderMan = new Hero(new Identity("Peter Parker"), new AlterEgo("Spider Man"), new Powers(Arrays.asList("super strength","webs","danger sense")));*/
        //delete db data
        //productRepo.deleteAll();
        if (productRepo.findAll().size() == 0) {
            //add db seeds
            Product p1 = new Product("iPhone X", "The best iPhone from two years ago", "http://t0.gstatic.com/images?q=tbn%3AANd9GcRW8XGcOjxKXwaSac9DZBorKNmorXylD6FBXD-hadNmP65I2PoLeIm6qW0B&usqp=CAc", 
            899.99, 100);
            Product p2 = new Product("OnePlus 7T", "An amazing 90Hz refresh rate smartphone", "http://t0.gstatic.com/images?q=tbn%3AANd9GcQjdRlr0JqvbLVyqp8xkbQOoWF3i-AcXW6vBcxVIHXwvu7hJVauYgmBWAFMdnT8CfzriDAtIBM&usqp=CAc", 
            599.99, 100);
            Product p3 = new Product("iPhone 11 Pro", "Apple's newest flagship smartphone", "http://t0.gstatic.com/images?q=tbn%3AANd9GcS-_4881rotpxV4ZBV6m0T933IuVJVwjB7SNR-WVmNC46a9a0kmHU5TZn2nnzMbvdg1pm_Pyv4&usqp=CAc", 
            999.00, 100);
            //delete db data
            // productRepo.deleteAll();
            //add db seeds
            List<Product> products = Arrays.asList(p1, p2, p3);
            productRepo.saveAll(products);
        }
    }

}