package com.example.courseday03.request;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpsertCourseRequest {
    @NotBlank(message = "Name is required")
    private  String name;

    @NotBlank(message = "Description is required")
    @Size(min = 50, message = "Lenght description must greater 50")
    private String description;

    @NotBlank(message = "Type is required")
    private String type;

    private List<String> topics;
    private String thumbnail;
    private int userID;
}
