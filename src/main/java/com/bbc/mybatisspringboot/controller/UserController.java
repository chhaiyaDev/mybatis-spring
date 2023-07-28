package com.bbc.mybatisspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bbc.mybatisspringboot.model.User;
import com.bbc.mybatisspringboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
    	try {
    		userService.deleteUserById(id);
    		return "User deleted.";
    	}catch (Exception e) {
			// TODO: handle exception
    		return e.getMessage();
		}
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
    	
    	User isExist = userService.getUserByEmail(user.getEmail());
  	
    	if(isExist!=null) {
    		return "Email already exist.";
    	}
    	
    	userService.saveUser(user);
    	return "User created.";
    }
    
 // update service
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody User user) {
    	
        userService.updateUser(id, user);
        
        return "User updated";
    }
}
