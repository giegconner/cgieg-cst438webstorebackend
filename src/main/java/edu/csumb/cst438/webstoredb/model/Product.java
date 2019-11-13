package edu.csumb.cst438.webstoredb.model;

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
        this.setName(name);
        this.setDescription(description);
        this.setImageURL(imageURL);
        this.setPrice(price);
        this.setStock(stock);
    }

    public String getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void decreaseStock(Integer amount) {
        this.stock -= amount;
    }
}