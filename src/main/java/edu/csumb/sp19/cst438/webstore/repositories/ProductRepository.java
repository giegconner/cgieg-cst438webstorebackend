package edu.csumb.sp19.cst438.webstore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import edu.csumb.sp19.cst438.webstore.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query (value = "{'id':?0}")
    Product findByRepoId(String id);
}