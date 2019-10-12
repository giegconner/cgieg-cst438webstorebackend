package edu.csumb.cst438.productdb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import edu.csumb.cst438.productdb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}