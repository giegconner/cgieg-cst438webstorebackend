package edu.csumb.cst438.webstoredb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.csumb.cst438.webstoredb.service.ProductService;
import edu.csumb.cst438.webstoredb.model.Product;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @ApiOperation(value = "Add a new product to Product table.")
    @PostMapping("/products/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    
    @ApiOperation(value = "Get a specific product from Product table by id.")
    @GetMapping("/products/get/{id}")
    public Product getProductById(@RequestParam String id) {
        return productService.findProductById(id);
    }

    @ApiOperation(value = "Retrieve all products from Product table.")
    @GetMapping("/products/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /*@ApiOperation(value = "Delete Product table. For testing purposes only.")
    @PostMapping("/products/deleteAll")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }*/
}