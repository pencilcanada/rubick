package com.pencilcanada.rubick.service;

import com.pencilcanada.rubick.api.dto.CourseDto;
import reactor.core.publisher.Mono;

public interface CourseService {
    Mono<CourseDto> getCourseById(String id);
}
