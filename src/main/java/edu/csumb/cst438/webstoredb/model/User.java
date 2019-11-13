package edu.csumb.cst438.webstoredb.model;

import java.util.HashMap;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "User")
public class User {
    @Id
    private String username;
    private String password;
    @ApiModelProperty(hidden = true)
    private HashMap<String, Integer> products;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.products = new HashMap<String, Integer>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public HashMap<String, Integer> getProducts() {
        return this.products;
    }
}