package com.example.courseday03.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;


}
