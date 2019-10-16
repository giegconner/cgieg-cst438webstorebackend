package edu.csumb.cst438.productdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Product")
public class Product {
    @Id @ApiModelProperty(hidden = true)
    private String id;
    private String name;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;

    // constructor parameter names must match member variable names
    public Product(String name, String description, String imageURL, 
    Double price, Integer stock) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getStock() {
        return this.stock;
    }
}