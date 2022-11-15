package com.example.courseday03.controller;

import com.example.courseday03.model.Course;
import com.example.courseday03.request.UpsertCourseRequest;
import com.example.courseday03.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    // Xem danh sách khóa học (GET /api/v1/admin/courses)
    @GetMapping("courses")
    public List<Course> findAllCourse(){
        return adminService.findAllCourse();
    }
    // Tạo khóa học mới (POST /api/v1/admin/courses)
    @PostMapping("courses")
    public Course creatCourse(@RequestBody UpsertCourseRequest upsertCourseRequest){
        return adminService.creatCourse(upsertCourseRequest);
    }
    //Lấy chi tiết khóa học (GET /api/v1/admin/courses/{id})
    @GetMapping("courses/{id}")
    public Course getCourse(@PathVariable int id){
        return adminService.getCourse(id);
    }
    // Cập nhật thông tin khóa học (PUT /api/v1/admin/courses/{id})
    @PutMapping("courses/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody UpsertCourseRequest upsertCourseRequest){
        return adminService.updateCourse(id, upsertCourseRequest);
    }
    //Xóa khóa học (DELETE /api/v1/admin/courses/{id})
    @DeleteMapping("courses/{id}")
    public void delCourse(@PathVariable int id){
        adminService.delCourse(id);
    }
}
