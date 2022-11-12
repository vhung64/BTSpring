package com.example.baithday02.service;

import com.example.baithday02.exception.NotFoundException;
import com.example.baithday02.model.User;
import com.example.baithday02.repository.UserRepository;
import com.example.baithday02.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUser(UserRequest userRequest) {
        if (userRepository.findByRequest(userRequest).isEmpty()) throw new NotFoundException("username hoặc password chưa chính xác");
        User user = userRepository.findByRequest(userRequest).get();
        return "username : "  + user.getUsername()
                + "\nemail : " + user.getEmail()
                + "\navatar : " + user.getAvatar();
    }
}
