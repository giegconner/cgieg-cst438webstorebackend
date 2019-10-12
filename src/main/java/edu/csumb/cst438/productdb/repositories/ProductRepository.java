package edu.csumb.cst438.productdb.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import edu.csumb.cst438.productdb.model.Hero;
import edu.csumb.cst438.productdb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query (value = "{'id':?0}")   
    Product findByRepoId(String id);

    /*@Query (value = "{'powers.powers':?0}")
    List<Hero> findByPower(String power);*/

}