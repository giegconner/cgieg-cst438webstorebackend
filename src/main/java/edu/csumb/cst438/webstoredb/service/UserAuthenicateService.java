package edu.csumb.cst438.webstoredb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.csumb.cst438.webstoredb.model.User;
import edu.csumb.cst438.webstoredb.repositories.UserRepository;

@Service
public class UserAuthenicateService {
    @Autowired
    UserRepository userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public boolean authenicateUser(String username, String password) {
        boolean isAutheticated = false;
        List<User> allUsers = userRepo.findAll();
        
        for (User user : allUsers) {
            String userUsername = user.getUsername();
            String userPassword = user.getPassword();
            if (userUsername.equals(username) && userPassword.equals(password)) {
                isAutheticated = true;
                break;
            }
        }
        return isAutheticated;
    }

    public void deleteAllUsers() {
        userRepo.deleteAll();
    }
}