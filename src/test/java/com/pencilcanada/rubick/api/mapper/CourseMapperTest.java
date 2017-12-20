package com.pencilcanada.rubick.api.mapper;

import com.pencilcanada.rubick.api.dto.CourseDto;
import com.pencilcanada.rubick.model.Course;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseMapperTest {

    public static final String TEST_COURSE_NAME="Math";
    public static final String TEST_COURSE_ID="01ec";

    @Test
    public void courseToCourseDto() throws Exception {
        Course course=new Course();
        course.setId(TEST_COURSE_ID);
        course.setTitle(TEST_COURSE_NAME);
        CourseDto courseDto=CourseMapper.INSTANCE.courseToCourseDto(course);
        assertEquals(TEST_COURSE_ID,courseDto.getId());
        assertEquals(course.getTitle(),courseDto.getTitle());
    }
}