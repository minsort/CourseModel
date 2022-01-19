package com.example.testProject.service;

import com.example.testProject.repository.CourseCompletionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CourseCompletionImplements {
    final
    CourseCompletionRepository courseCompletionRepository;

    public CourseCompletionImplements(CourseCompletionRepository courseCompletionRepository) {
        this.courseCompletionRepository = courseCompletionRepository;
    }

    //Получаем текущий средний балл
    public List<Float> averageScore(@RequestParam("std_id") Long students_id) {
        return courseCompletionRepository.averageScore(students_id);
    }

    //Получит финальную отметку
    public List<Integer> finalScore(@RequestParam("std_id") Long students_id) {
        return courseCompletionRepository.finalScore(students_id);
    }

}

















