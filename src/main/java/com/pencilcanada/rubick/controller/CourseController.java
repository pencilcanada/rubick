package com.pencilcanada.rubick.controller;

import com.pencilcanada.rubick.api.dto.CourseDto;
import com.pencilcanada.rubick.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CourseController.BASE_URL)
public class CourseController {

    private CourseService courseService;

    public static final String BASE_URL = "/course";

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    Mono<ResponseEntity<CourseDto>> findCourseById(@PathVariable String id){
        return courseService.getCourseById(id)
                .map(courseDto -> ResponseEntity.ok(courseDto))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
