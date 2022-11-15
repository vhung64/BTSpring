package com.example.courseday03.service;

import com.example.courseday03.exception.NotFoundException;
import com.example.courseday03.model.Course;
import com.example.courseday03.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findListCourse(String type, String name, String topic) {
        if(courseRepository.findListCourse(type,name,topic) == null)
            throw new NotFoundException("Khong co khoa hoc hop le");
        else return courseRepository.findListCourse(type,name,topic);
    }

    public Course findCourseById(int id) {
        return courseRepository.getCourseById(id).orElseThrow(()->{
            throw new NotFoundException("Khong co id khoa hoc hop le");
        });

    }
}
