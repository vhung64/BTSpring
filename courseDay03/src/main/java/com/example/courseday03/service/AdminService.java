package com.example.courseday03.service;

import com.example.courseday03.exception.NotFoundException;
import com.example.courseday03.model.Course;
import com.example.courseday03.repository.CourseRepository;
import com.example.courseday03.request.UpsertCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AdminService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    public Course creatCourse(UpsertCourseRequest upsertCourseRequest) {
        return courseRepository.creatCourse(upsertCourseRequest);
    }

    public Course getCourse(int id) {
        return courseRepository.getCourseById(id).orElseThrow(() -> {
            throw new NotFoundException("Khong co id khoa hoc hop le");
        });
    }

    public Course updateCourse(int id, UpsertCourseRequest upsertCourseRequest) {
        return courseRepository.updateCourse(id,upsertCourseRequest);

    }

    public void delCourse(int id) {
        courseRepository.delCoure(id);
    }
}
