package edu.csumb.cst438.webstoredb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.csumb.cst438.webstoredb.model.User;
import edu.csumb.cst438.webstoredb.service.UserAuthenicateService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserAuthenticateController {
    @Autowired
    UserAuthenicateService userService;

    @ApiOperation(value = "Add a user to User table.")
    @PostMapping("/users/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @ApiOperation(value = "Authenicate a user before they log in.")
    @GetMapping("/users/auth/{username}/{password}")
    public boolean authenicateUser(@RequestParam String username, @RequestParam String password) {
        return userService.authenicateUser(username, password);
    }

    @ApiOperation(value = "Retrieve all users from User table.")
    @PostMapping("/users/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    /*@ApiOperation(value = "Delete all users from User table. For testing purposes only.")
    @PostMapping("/users/deleteAll")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }*/
}