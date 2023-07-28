package com.bbc.mybatisspringboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bbc.mybatisspringboot.model.User;

@Mapper
public interface UserMapper {

	// list all users
    List<User> getAllUsers();
	
    // get user by id
    User getUserById(long id);
    
    // create new user
    void insertUser(User user);
    
    // delete user 
    void deleteUser(long id);
  
    // find user by email 
    User findByEmail(String email);
    
    // update user by id
    void updateUser(User user); 
    
    // find email not id 
    User findByEmailAndNotId(String email, Long id);
}
