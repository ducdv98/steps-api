package com.ducdv.stepsapi.repository;

import com.ducdv.stepsapi.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, String> {
    UserInfo findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}