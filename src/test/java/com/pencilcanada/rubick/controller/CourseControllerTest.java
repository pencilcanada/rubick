package com.pencilcanada.rubick.controller;

import com.pencilcanada.rubick.api.dto.CourseDto;
import com.pencilcanada.rubick.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CourseControllerTest {
    @Mock
    CourseService courseService;

    private WebTestClient client;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        client = WebTestClient.bindToController(new CourseController(courseService))
                .controllerAdvice(new GeneralExceptionHandler()).configureClient().baseUrl(CourseController.BASE_URL).build();
    }

    @Test
    public void findCourseByIdTest() throws Exception {
        String testCourseId="0001";
        String testCourseTitle="Math";

        CourseDto courseDto=new CourseDto();
        courseDto.setId(testCourseId);
        courseDto.setTitle(testCourseTitle);
        when(courseService.getCourseById(anyString())).thenReturn(Mono.just(courseDto));
        this.client.get().uri("/0001")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.title").isEqualTo(testCourseTitle)
                .jsonPath("$.id").isEqualTo(testCourseId);
    }

    @Test
    public void courseNotFoundTest() throws Exception {
        when(courseService.getCourseById(anyString())).thenReturn(Mono.empty());
        this.client.get().uri("/0001")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isNotFound().expectBody().isEmpty();
    }

    @Test
    public void runTimeExceptionTest() throws Exception {
        when(courseService.getCourseById(anyString())).thenThrow(new RuntimeException());
        this.client.get().uri("/0001")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isBadRequest().expectBody().isEmpty();
    }
}