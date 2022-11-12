package com.example.baithday02.database;

import com.example.baithday02.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserFakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1, "account1","acc1@gmail.com" ,"password1","Avatar con meo"),
            new User(2, "account2","acc2@gmail.com" ,"password2","Avatar con cho"),
            new User(3, "account3","acc3@gmail.com" ,"password3","Avatar con cuu"),
            new User(4, "account4","acc4@gmail.com" ,"password4","Avatar con tho"),
            new User(5, "account5","acc5@gmail.com" ,"password5","Avatar con de")
    ));
}
