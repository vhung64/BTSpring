package com.example.ktraspringbootrestapi.database;

import com.example.ktraspringbootrestapi.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1, "Bùi Hiên", "buihien01091997@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas1"),
            new User(2, "Trịch Hiên", "2@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas2"),
            new User(3, "Nguyễn Hiên", "3@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas3"),
            new User(4, "Bùi Hiên4", "4@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas4"),
            new User(5, "Bùi Hiên5", "5@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas5"),
            new User(6, "Bùi Hiên6", "6@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas6"),
            new User(7, "Bùi Hiên7", "7@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas7"),
            new User(8, "Bùi Hiên8", "8@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas8"),
            new User(9, "Bùi Hiên9", "9@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas9"),
            new User(10, "Bùi Hiên10", "10@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas10"),
            new User(11, "Bùi Hiên11", "11@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas11"),
            new User(12, "Bùi Hiên12", "12@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas12"),
            new User(13, "Bùi Hiên13", "13@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas13"),
            new User(14, "Bùi Hiên14", "14@gmail.com", "0344005816", "Tỉnh Thái Bình",null,"pas14")
    ));
}
