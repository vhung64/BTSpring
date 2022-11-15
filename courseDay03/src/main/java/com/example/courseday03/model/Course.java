package com.example.courseday03.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private int id;
    private  String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private int userID;

}
