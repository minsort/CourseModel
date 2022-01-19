package com.example.testProject.controller;


import com.example.testProject.models.Course;
import com.example.testProject.repository.CourseRepository;
import com.example.testProject.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class CourseController {
    final CourseService courseService;
    final CourseRepository courseRepository;
    public CourseController(CourseService courseService, CourseRepository courseRepository) {
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }
//Возвращает список прослушенных студентом курсов
    @GetMapping(value = "/course", produces = "application/json")
    public List<String> allCourse (@RequestParam("std_id") Long students_id){
        return courseService.allCourse(students_id);
    }









}
