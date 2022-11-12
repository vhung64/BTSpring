package com.example.baithday02.repository;

import com.example.baithday02.database.UserFakeDB;
import com.example.baithday02.model.User;
import com.example.baithday02.request.UserRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> findByRequest(UserRequest userRequest){
        return UserFakeDB.users
                .stream()
                .filter(user -> (user.getUsername().equals(userRequest.getUsername())
                        && user.getPassword().equals(userRequest.getPassword())))
                .findFirst();
    }
}
