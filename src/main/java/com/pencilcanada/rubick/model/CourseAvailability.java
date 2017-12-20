package com.pencilcanada.rubick.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class CourseAvailability {
    private LocalTime time;
    private int availability;
}
