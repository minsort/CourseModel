package com.example.testProject.service;

import com.example.testProject.models.CourseCompletion;
import com.example.testProject.repository.CourseCompletionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCompletionImplements {


    final
    CourseCompletionRepository courseCompletionRepository;

    public CourseCompletionImplements(CourseCompletionRepository courseCompletionRepository) {
        this.courseCompletionRepository = courseCompletionRepository;
    }

    //Получаем текущий средний балл
    public String avgScores() {
        String s = courseCompletionRepository.avgScores();
        return s;
    }

    //Финальная отметка.        (Надеюсь, ко мне не будут так требовательны, как я в своих расчетах:)))
    public Integer endScores() {
        return Integer.parseInt(courseCompletionRepository.avgScores());
    }












 /*  public void addOnCourse(){
        courseCompletionRepository.addOnCourse();
   }*/











}