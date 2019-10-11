package edu.csumb.sp19.cst438.webstore.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import edu.csumb.sp19.cst438.webstore.service.ProductService;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import edu.csumb.sp19.cst438.webstore.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Add a new product to the database.")
    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        Product result = productService.addProduct(product);
        return result;
    }

    @ApiOperation(value = "Get a specific product from the database by its ID.")
    @GetMapping("/products/get/{id}")
    public Product getProductById(@PathVariable String id) {
        Product result = productService.getProductById(id);
        return result;
    }

    @ApiOperation(value = "Get all products from the database.")
    @GetMapping("/products/getAll")
    public List<Product> getAllProducts() {
        List<Product> results = productService.getAllProducts();
        return results;
    }

    @GetMapping("/someData")
    public String getThirdPartyData (){
        RestTemplate myTemplate = new RestTemplate();
        String resourceUrl = "https://reqres.in/api/users";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<String> response = myTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        return response.getBody();
        //return "hello"; 
    }
}