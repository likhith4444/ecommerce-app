package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Allows frontend to access backend API
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    // Add product to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartRepo.findByUserAndProductId(user, productId);

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
        }

        return cartRepo.save(cartItem);
    }

    // Get all items in user's cart
    @GetMapping("/user/{userId}")
    public List<CartItem> getUserCart(@PathVariable Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return cartRepo.findByUser(user);
    }

    // Increase quantity
    @PutMapping("/increase")
    public CartItem increaseQuantity(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        CartItem cartItem = cartRepo.findByUserAndProductId(user, productId);

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            return cartRepo.save(cartItem);
        }

        throw new RuntimeException("Cart item not found");
    }

    // Decrease quantity
    @PutMapping("/decrease")
    public CartItem decreaseQuantity(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        CartItem cartItem = cartRepo.findByUserAndProductId(user, productId);

        if (cartItem != null && cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            return cartRepo.save(cartItem);
        } else if (cartItem != null) {
            cartRepo.delete(cartItem);
            return null;
        }

        throw new RuntimeException("Cart item not found");
    }

    // Remove item from cart
    @DeleteMapping("/remove")
    public String removeFromCart(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        CartItem cartItem = cartRepo.findByUserAndProductId(user, productId);

        if (cartItem != null) {
            cartRepo.delete(cartItem);
            return "Item removed from cart";
        }

        return "Item not found in cart";
    }
}
