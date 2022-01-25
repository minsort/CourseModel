package com.example.testProject.controller;

import com.example.testProject.service.CourseCompletionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
@Slf4j
public class CourseCompletionController {
    private final CourseCompletionService courseCompletionService;
    public CourseCompletionController(CourseCompletionService courseCompletionService) {
        this.courseCompletionService = courseCompletionService;}

    //Получить текущий средний балл студента
    //Пример запроса: /score/final?std_id=51
    @GetMapping(value = "/average", produces = "application/json")
    public List<Float> averageScore (@RequestParam("std_id") Long stud_id){
        log.info("Получаем средний бал, где ID студента = {}", stud_id);
        return courseCompletionService.averageScore(stud_id);
    }

    //Получить финальную отметку
    //Пример запроса: /score/final?std_id=51
    //Испульзует ROUND (PostgreSQL) для округления значения
    @GetMapping(value = "/final", produces = "application/json")
    public List<Integer> finalScore (@RequestParam("std_id") Long stud_id){
        log.info("Получаем финальную отметку, где ID студента = {}", stud_id);
        return courseCompletionService.finalScore(stud_id);
    }
}

