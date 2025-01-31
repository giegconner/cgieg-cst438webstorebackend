package edu.csumb.cst438.webstoredb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import edu.csumb.cst438.webstoredb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query (value = "{'id':?0}")
    Product findByProductId(String id);
}