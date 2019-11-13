package edu.csumb.cst438.webstoredb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.csumb.cst438.webstoredb.model.User;
import edu.csumb.cst438.webstoredb.service.UserCartService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserCartController {
    @Autowired
    UserCartService userCartService;

    @ApiOperation(value = "Add a user's product id with a quantity to their cart.")
    @GetMapping("/users/cart/add/{username}/{productId}/{quantity}")
    public User addProductToCart(@RequestParam String username, 
    @RequestParam String productId, @RequestParam Integer quantity) {
        return userCartService.addProductToCart(username, productId, quantity);
    }

    @ApiOperation(value = "Change user's product id with a quantity or remove a product id from their cart.")
    @GetMapping("/users/cart/change/{username}/{productId}/{quantity}")
    public User changeProductInCart(@RequestParam String username, 
    @RequestParam String productId, @RequestParam Integer quantity) {
        return userCartService.changeProductFromCart(username, productId, quantity);
    }

    @ApiOperation(value = "Clear the user's cart and removes the specified quantity of each product from the stock of all products specified.")
    @GetMapping("/users/cart/checkout/{username}")
    public User clearProductsFromCart(@RequestParam String username) {
        return userCartService.clearProductsFromCart(username);
    }

    @ApiOperation(value = "Retrieve all user's carts")
    @PostMapping("/users/cart/getAll")
    public List<User> getAllUsersCarts() {
        return userCartService.getAllUsersCarts();
    }
}