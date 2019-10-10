package edu.csumb.sp19.cst438.webstore.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Product")
public class Product {
    private String name;
    @Id
    private String id;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;

    public Product(String aName, String aDescription,
    String aImageURL, Double aPrice, Integer aStock) {
        this.name = aName;
        this.description = aDescription;
        this.imageURL = aImageURL;
        this.price = aPrice;
        this.stock = aStock;
    }

    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
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