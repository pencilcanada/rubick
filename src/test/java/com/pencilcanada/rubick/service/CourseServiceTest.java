package com.pencilcanada.rubick.service;

import com.pencilcanada.rubick.api.dto.CourseDto;
import com.pencilcanada.rubick.api.mapper.CourseMapper;
import com.pencilcanada.rubick.model.Course;
import com.pencilcanada.rubick.repository.CourseRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

public class CourseServiceTest {

    CourseService courseService;
    @Mock
    CourseRepository courseRepository;

    public static final String TEST_COURSE_NAME="Math";
    public static final String TEST_COURSE_ID="01ec";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        courseService=new CourseServiceImpl(courseRepository, CourseMapper.INSTANCE);
    }

    @Test
    public void getCourseById() throws Exception {
        Course course=new Course();
        course.setId(TEST_COURSE_ID);
        course.setTitle(TEST_COURSE_NAME);
        when(courseRepository.findById(anyString())).thenReturn(Mono.just(course));
        Mono<CourseDto> courseDto=courseService.getCourseById("");
        assertEquals(TEST_COURSE_ID,courseDto.block().getId());
    }

}