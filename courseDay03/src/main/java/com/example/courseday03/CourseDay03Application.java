package com.example.courseday03;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseDay03Application {

    public static void main(String[] args) {

        SpringApplication.run(CourseDay03Application.class, args);
    }
    @Bean
    public Faker faker(){
        return new Faker();
    }

}
