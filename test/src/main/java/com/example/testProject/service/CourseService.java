package com.example.testProject.service;

import com.example.testProject.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CourseService {
final CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //Получает список прослушенных курсов
    public List<String> allCourse (@RequestParam("std_id") Long students_id) {
        return courseRepository.allCoursesOfStudents(students_id);
    }
}
