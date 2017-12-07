package com.pencilcanada.rubick.repository;

import com.pencilcanada.rubick.model.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends ReactiveCrudRepository <Course,String> {
}
