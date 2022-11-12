package com.example.baithday02.model;

import lombok.*;

import java.beans.ConstructorProperties;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String avatar;

    public User(String username, String email, String avatar) {
        this.username = username;
        this.email = email;
        this.avatar = avatar;
    }
}
