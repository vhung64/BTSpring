package com.example.baithday02.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ColorService {
    public String randomColor(int type){
        return switch(type){
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRgbColor();
            default -> throw new RuntimeException("Type khong hop le");
        };
    }

    private String randomRgbColor() {
        Random rand = new Random();
        // Java 'Color' class takes 3 floats, from 0 to 1.
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        String result = "rgb(" + r + ", " + g + ", "+ b+")";
        return result;
    }

    private String randomHexColor() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        // format it as hexadecimal string and print
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }

    private String randomColorName() {
        List<String> colors = List.of("black", "blue", "red", "green");
        Random rd = new Random();
        int temp = rd.nextInt(colors.size());
        return colors.get(temp);
    }
}
