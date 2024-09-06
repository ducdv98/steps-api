package com.ducdv.stepsapi.service.impl;

import com.ducdv.stepsapi.entity.UserInfo;
import com.ducdv.stepsapi.repository.UserRepository;
import com.ducdv.stepsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserInfo> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UserInfo createUser(UserInfo user) {
        return userRepository.save(user);
    }

    @Override
    public UserInfo updateUser(String id, UserInfo user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void registerUser(UserInfo user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        userRepository.save(user);
    }
}
