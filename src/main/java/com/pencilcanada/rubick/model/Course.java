package com.pencilcanada.rubick.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "course")
public class Course {
    @Id
    private String id;
    private String tutorId;
    private String title;
    private String description;
    private Address location;
    private String[] categories;

    private int capability;
    private int duration;
    private CourseAvailability[] availabilities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id != null ? id.equals(course.id) : course.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
