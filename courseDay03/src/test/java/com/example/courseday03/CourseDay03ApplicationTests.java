package com.example.courseday03;

import com.example.courseday03.model.Course;
import com.example.courseday03.model.User;
import com.example.courseday03.repository.CourseRepository;
import com.example.courseday03.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseDay03ApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void test_data(){
        List<User> user = userRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        courses.forEach(System.out::println);
    }

}
