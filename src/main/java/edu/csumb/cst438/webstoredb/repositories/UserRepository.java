package edu.csumb.cst438.webstoredb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import edu.csumb.cst438.webstoredb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query (value = "{'username':?0}")
    User findByUsername(String username);
}