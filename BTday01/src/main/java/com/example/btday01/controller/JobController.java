package com.example.btday01.controller;

import com.example.btday01.model.Job;
import com.example.btday01.request.UpsertJobRequest;
import com.example.btday01.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JobController {
    @Autowired
    private JobService jobService;
    private UpsertJobRequest request;

    // trả về một job ngẫu nhiên trong danh sách
    @GetMapping("jobs/random")
    public Job getRamdomJob(){
        return jobService.getRandomJob();
    }
    // trả về danh sách job được sắp xếp giảm dần theo lương tối đa
    @GetMapping("sort")
    public List<Job> getListJobs(@RequestParam int max_salary){
        return jobService.getListJobs(max_salary);
    }
    //Lấy danh sách tất cả job
    @GetMapping("jobs")
    public List<Job> getJobs(){
        return  jobService.getJobs();
    }
    // Lấy chi tiết 1 job
    @GetMapping("jobs/{id}")
    public Job getListById(@PathVariable String id){
        return jobService.getListById(id);
    }
    // Tạo mới book -> Đối tượng sau khi tạo
    @PostMapping("jobs")
    public Job creatJob(@RequestBody UpsertJobRequest request){
        return jobService.creatJob(request);
    }
    // Cập nhật thông tin job -> Đối tượng sau khi cập nhật
    @PutMapping("jobs/{id}")
    public Job updateJob(@RequestBody UpsertJobRequest request,@PathVariable String id){
        return jobService.updateJob(request, id);
    }
    // Xóa job theo id
    @DeleteMapping("jobs/{id}")
    public void delJob(@PathVariable String id){
        jobService.delJob(id);
    }

}
