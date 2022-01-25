package com.example.testProject.controller;

import com.example.testProject.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/get")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
//Возвращает список прослушенных студентом курсов
    @GetMapping(value = "/course", produces = "application/json")
    public List<String> allCourse (@RequestParam("std_id") Long students_id){
        log.info("Получаем список прослушенных курсов, где ID студента = {}", students_id);
        return courseService.allCourse(students_id);
    }

}
