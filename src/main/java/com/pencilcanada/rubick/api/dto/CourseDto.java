package com.pencilcanada.rubick.api.dto;

import com.pencilcanada.rubick.model.Address;
import com.pencilcanada.rubick.model.CourseAvailability;
import lombok.Data;

@Data
public class CourseDto {
    private String id;
    private String tutorId;
    private String title;
    private String description;
    private Address location;
    private String[] categories;

    private int capability;
    private int duration;
    private CourseAvailability[] availabilities;
}
