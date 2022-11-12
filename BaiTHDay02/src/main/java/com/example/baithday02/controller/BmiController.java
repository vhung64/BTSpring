package com.example.baithday02.controller;

import com.example.baithday02.request.BMIRequest;
import com.example.baithday02.service.BmiService;
import com.example.baithday02.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping("bmi")
    public double getBmi(@RequestParam double height,@RequestParam double weight ) {
        return bmiService.getBMI(height, weight);
    }

    @PostMapping("bmi")
    public double getBMIByPost(@RequestBody BMIRequest bmiRequest){
        return bmiService.getBMIByPost(bmiRequest);
    }

}
