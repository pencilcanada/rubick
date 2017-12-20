package com.pencilcanada.rubick.api.mapper;

import com.pencilcanada.rubick.api.dto.CourseDto;
import com.pencilcanada.rubick.model.Course;
import org.mapstruct.factory.Mappers;

public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto courseToCourseDto(Course course);
}
