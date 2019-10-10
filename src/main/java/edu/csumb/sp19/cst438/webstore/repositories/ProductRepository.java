package edu.csumb.sp19.cst438.webstore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import edu.csumb.sp19.cst438.webstore.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query (value = "{'id':?0}")
    Product findByRepoId(String id);
}