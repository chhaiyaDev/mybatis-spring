package com.bbc.mybatisspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.mybatisspringboot.mapper.UserMapper;
import com.bbc.mybatisspringboot.model.User;

@Service
public class UserService {
	
	private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // list all user
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    // get user by id
    public User getUserById(long id) {
        return userMapper.getUserById(id);
    }
    
    // create new user 
    public String saveUser(User user) {
    	User isExist = userMapper.findByEmail(user.getEmail());
    	if(isExist!=null) {
    		return "Email already exist.";
    	}
    	userMapper.insertUser(user);
    	return "created";
    }
    
    // delete user 
    public void deleteUserById(long id) {
    	userMapper.deleteUser(id);
    }
    
    // update user
    public void updateUser(Long id, User user) {
    	User existingUser = userMapper.getUserById(id);
    	if(existingUser != null) {
    		existingUser.setFirstName(user.getFistName());
    		existingUser.setLastName(user.getLastName());
    		existingUser.setEmail(user.getEmail());
    		existingUser.setPhone(user.getPhone());
    		existingUser.setPassword(user.getPassword());
    		userMapper.updateUser(existingUser);	
    	}
    }

    // find user by id
    public User getUserByEmail(String email) {
    	return userMapper.findByEmail(email);
    }
    
    // find email not id
    public User getUserByEmaillNotId(String email, Long id) {
    	return userMapper.findByEmailAndNotId(email, id);
    }
}
