package com.example.courseday03.repository;

import com.example.courseday03.exception.NotFoundException;
import com.example.courseday03.model.Course;
import com.example.courseday03.model.User;
import com.example.courseday03.request.UpsertCourseRequest;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CourseRepository {
    private List<Course> courses;
    private Faker faker;
    private UserRepository userRepository;

    public CourseRepository(Faker faker, UserRepository userRepository) {
        this.faker = faker;
        this.userRepository = userRepository;
        initCourses();
    }

    public void initCourses(){
        Random rd = new Random();
        List<String> topics = List.of("Frontend", "Backend", "Database", "devops", "AWS");
        List<User> users = userRepository.findAll();
        courses = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            List<String>  rdTopics = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String rdTopic = topics.get(rd.nextInt(topics.size()));
                if(!rdTopics.contains(rdTopic))
                    rdTopics.add(rdTopic);
            }
            Course course = new Course(
                    i,
                    faker.funnyName().name(),
                    faker.lorem().sentence(20),
                    rd.nextInt(2) == 1 ? "online" : "onlab",
                    rdTopics,
                    faker.avatar().image(),
                    users.get(rd.nextInt(users.size())).getId());
            courses.add(course);
        }
    }
    public List<Course> findAll(){
        return courses;
    }

    public Optional<Course> getCourseById(int id) {
        return  courses
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }
    public Course creatCourse(UpsertCourseRequest upsertCourseRequest) {
        Random rd = new Random();
        Course course = new Course(
                rd.nextInt(200),
                upsertCourseRequest.getName(),
                upsertCourseRequest.getDescription(),
                upsertCourseRequest.getType(),
                upsertCourseRequest.getTopics(),
                upsertCourseRequest.getThumbnail(),
                upsertCourseRequest.getUserID()
        );
        courses.add(course);
        return course;
    }
    public Course updateCourse(int id, UpsertCourseRequest upsertCourseRequest) {
        for (Course course : courses){
            if(course.getId() == id){
                course.setDescription(upsertCourseRequest.getDescription());
                course.setType(upsertCourseRequest.getType());
                course.setName(upsertCourseRequest.getName());
                course.setTopics(upsertCourseRequest.getTopics());
                course.setThumbnail(upsertCourseRequest.getThumbnail());
                course.setUserID(upsertCourseRequest.getUserID());
                return course;
            }
        }
        throw new NotFoundException("Khong co id khoa hoc hop le");
    }

    public void delCoure(int id) {
        if (getCourseById(id).isPresent())
            courses.removeIf(course -> course.getId() == id);
        else throw new NotFoundException("Khong co id khoa hoc hop le");
    }

    // User
    public List<Course> findListCourse(String type, String name, String topic){
        List<Course> result = new ArrayList<>();
        for(Course course : courses){
            if((type == null || course.getType().equals(type))
            && (name == null || course.getName().equals(name))
            && (topic == null || course.getTopics().contains(topic)))
                result.add(course);
        }
        return result;
    }
}
