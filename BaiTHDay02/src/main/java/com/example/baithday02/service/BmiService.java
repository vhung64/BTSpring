package com.example.baithday02.service;

import com.example.baithday02.exception.BadRequestException;
import com.example.baithday02.request.BMIRequest;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public double getBMI(double height, double weight) {
        if(height <= 0 || weight <= 0)
            throw new BadRequestException("Can nang, chieu cao phai lon hon 0");
        return weight/(height*height);
    }

    public double getBMIByPost(BMIRequest bmiRequest) {
        return getBMI(bmiRequest.getHeight(),bmiRequest.getWeight());
    }
}
