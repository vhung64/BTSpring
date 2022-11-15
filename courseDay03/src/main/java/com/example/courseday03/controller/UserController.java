package com.example.courseday03.controller;

import com.example.courseday03.exception.NotFoundException;
import com.example.courseday03.model.Course;
import com.example.courseday03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    // Xem danh sách tất cả khóa học (GET /api/v1/courses?type={typeValue}name={nameValue}&topic={topicValue}) - trong đó type hoặc name hoặc topic có thể có hoặc không
    @GetMapping("/api/v1/courses")
    public List<Course> findListCourse(@RequestParam(name = "type", required = false)  String type, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "topic", required = false) String topic){
        return userService.findListCourse(type,name,topic);
    }
    // Xem thông tin của 1 khóa học cụ thể (thông tin bao gồm thông tin khóa học và nhân viên tư vấn) (GET /api/v1/courses/{id})
    @GetMapping("/api/v1/courses/{id}")
    public Course findCourseById(@PathVariable int id){
        return  userService.findCourseById(id);
    }
}
