package com.example.btday01.service;

import com.example.btday01.model.Job;
import com.example.btday01.request.UpsertJobRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class JobService {
    private List<Job> jobs;
    public JobService(){
        jobs = new ArrayList<>();
        jobs.add(new Job("a","Dentist", "Bac si nha khoa", "Ha Noi", 400, 1000, "dentist@gmail.com"));
        jobs.add(new Job("b","Registered Nurse", "Y ta", "Hai Duong", 50, 500, "registered@gmail.com"));
        jobs.add(new Job("c","Pharmacist", "Duoc si", "Hai Phong", 100, 600, "pharmacist@gmail.com"));
        jobs.add(new Job("d","Physician", "Bac si", "Ha Noi", 200, 700, "physician@gmail.com"));
    }
    public Job getRandomJob(){
        Random rd = new Random();
        int temp = rd.nextInt(jobs.size());
        return jobs.get(temp);
    }
    public List<Job> getListJobs( int desc){
        List<Job> result = new ArrayList<>();
        for (Job job : jobs){
            if(job.getMaxSalary() <= desc){
                result.add(job);
            }
        }
        result.sort((o1, o2) -> o1.getMaxSalary() < o2.getMaxSalary() ? 1 : -1);
        return result;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public Job getListById(String id) {
        for (Job job : jobs){
            if (id.equals(job.getId()))
                return job;
        }
        return null;
    }

    public Job creatJob(UpsertJobRequest request) {
        String id = generateString(3);
        Job job = new Job(
                id,
                request.getTitle(),
                request.getDescription(),
                request.getLocation(),
                request.getMinSalary(),
                request.getMaxSalary(),
                request.getEmailTo()
        );
        jobs.add(job);
        return job;
    }
    public String generateString(int n){
        String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        while (n > 0){
            int i = rd.nextInt(AlphaString.length());
            sb.append(AlphaString.charAt(i));
            n--;
        }
        return sb.toString();

    }

    public Job updateJob(UpsertJobRequest request, String id) {
        for (Job job : jobs){
            if (id.equals(job.getId())){
                job.setDescription(request.getDescription());
                job.setTitle(request.getTitle());
                job.setLocation(request.getLocation());
                job.setEmailTo(request.getEmailTo());
                job.setMaxSalary(request.getMaxSalary());
                job.setMinSalary(request.getMinSalary());
                return job;
            }
        }
        return null;
    }
    public void delJob(String id){
        jobs.removeIf(book -> book.getId().equals(id));
    }
}
