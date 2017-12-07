package com.pencilcanada.rubick.pojo;

import java.time.LocalTime;

public class CourseAvailability {
    private LocalTime time;
    private int availability;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
