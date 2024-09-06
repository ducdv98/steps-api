package com.ducdv.stepsapi.service;

import com.ducdv.stepsapi.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserInfo> getAllUsers();
    Optional<UserInfo> getUserById(String id);
    UserInfo createUser(UserInfo user);
    UserInfo updateUser(String id, UserInfo user);
    void deleteUser(String id);
    public void registerUser(UserInfo user);
}