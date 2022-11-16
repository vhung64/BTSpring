package com.example.ktraspringbootrestapi.request;


import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class UpsertUserRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String password;
}
