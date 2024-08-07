package com.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecommerce.entity.User;
import com.ecom.ecommerce.exception.UserNotFoundException;
import com.ecom.ecommerce.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found with id "+id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
    	if(!userRepository.existsById(id)) {
    		throw new UserNotFoundException("user Not Found With Id "+id);
    		
    	}
        userRepository.deleteById(id);
    }
}
