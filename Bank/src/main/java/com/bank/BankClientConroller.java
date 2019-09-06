package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bank.model.User;
import com.bank.repo.UserRepository;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BankClientConroller {

@Autowired
    UserRepository userRepository;

// Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

// Create a new User
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

// Get a Single User by ID
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId);
    }
    
 // Get a Single User ID by email and password
    @PostMapping("/user")
    public User createUserDeposit(@Valid @RequestBody User user) {
		return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    } 
}