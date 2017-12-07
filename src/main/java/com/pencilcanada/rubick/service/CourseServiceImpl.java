package com.pencilcanada.rubick.service;

import com.pencilcanada.rubick.api.dto.CourseDto;
import com.pencilcanada.rubick.api.mapper.CourseMapper;
import com.pencilcanada.rubick.repository.CourseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements  CourseService{

    private final CourseRepository courseRepository;
    CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public Mono<CourseDto> getCourseById(String id) {
        return courseRepository.findById(id).map(course -> courseMapper.courseToCourseDto(course));
    }
}
