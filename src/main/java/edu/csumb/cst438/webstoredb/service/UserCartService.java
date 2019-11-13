package edu.csumb.cst438.webstoredb.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.csumb.cst438.webstoredb.model.User;
import edu.csumb.cst438.webstoredb.model.Product;
import edu.csumb.cst438.webstoredb.repositories.ProductRepository;
import edu.csumb.cst438.webstoredb.repositories.UserRepository;

@Service
public class UserCartService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    ProductRepository productRepo;

    public User addProductToCart(String username, String productId, Integer quantity) {
        User targetUser = userRepo.findByUsername(username);
        HashMap<String, Integer> products = targetUser.getProducts();
        if (quantity != 0) {
            // product id exists in user's cart
            if (products.containsKey(productId)) {
                products.put(productId, products.get(productId) + quantity);
            }
            // product id doesn't exist in user's cart
            else {
                products.put(productId, quantity);
            }
        }
        userRepo.save(targetUser);
        return targetUser;
    }

    public User changeProductFromCart(String username, String productId, Integer quantity) {
        User targetUser = userRepo.findByUsername(username);
        HashMap<String, Integer> products = targetUser.getProducts();
        if (quantity == 0) {
            // remove product id from user's cart
            products.remove(productId);
        }
        else {
            // change the product id quantity
            products.put(productId, quantity);
        }
        userRepo.save(targetUser);
        return targetUser;
    }

    public User clearProductsFromCart(String username) {
        User targetUser = userRepo.findByUsername(username);
        if (targetUser != null) {
            HashMap<String, Integer> products = targetUser.getProducts();
            for (String id : products.keySet()) {
                Product targetProduct = productRepo.findByProductId(id);
                Integer quantity = products.get(id);
                if (targetProduct != null) {
                    targetProduct.decreaseStock(quantity);
                    for (Product product : productRepo.findAll()) {
                        String productId = product.getId();
                        String targetProductId = targetProduct.getId();
                        if (productId.equals(targetProductId)) {
                            productRepo.save(targetProduct);
                        }
                    }
                }
            }
            products.clear();
            userRepo.save(targetUser);
        }
        
        return targetUser;
    }

    public List<User> getAllUsersCarts() {
        return userRepo.findAll();
    }
}