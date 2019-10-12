package edu.csumb.cst438.productdb.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import edu.csumb.cst438.productdb.service.ProductService;
import edu.csumb.cst438.productdb.model.Product;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @ApiOperation(value = "Add a new product to the database.")
    @PostMapping("/products/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    
    @ApiOperation(value = "Get a specific product from the database by its ID.")
    @GetMapping("/products/get/{id}")
    public Optional<Product> getProductById(@RequestParam String id) {
        return productService.findProductById(id);
    }

    @ApiOperation(value = "Get all products from the database.")
    @GetMapping("/products/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @ApiOperation(value = "Delete all database Product table records.  For testing purposes only.")
    @PostMapping("/products/deleteAll")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }
    	
    /*@GetMapping("/power/{power}")
    public List<Product> getByPower (@PathVariable String power) {
        List<Product> result = productRepo.findByPower(power);
        return result;
    }*/

    /*@GetMapping("/someData")
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
    }*/
	
}