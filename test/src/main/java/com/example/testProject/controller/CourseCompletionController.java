
package com.example.testProject.controller;


import com.example.testProject.models.CourseCompletion;
import com.example.testProject.repository.CourseCompletionRepository;
import com.example.testProject.service.CourseCompletionImplements;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class CourseCompletionController {
    final CourseCompletionImplements courseCompletionImplements;
    final CourseCompletionRepository courseCompletionRepository;
    public CourseCompletionController( CourseCompletionImplements courseCompletionImplements,
                                       CourseCompletionRepository courseCompletionRepository) {
        this.courseCompletionImplements = courseCompletionImplements;
        this.courseCompletionRepository = courseCompletionRepository;
    }

    //Получить текущий средний балл студента
    //Пример запроса: /score/final?std_id=51
    @GetMapping(value = "/average", produces = "application/json")
    public List<Float> averageScore (@RequestParam("std_id") Long stud_id){
        return courseCompletionImplements.averageScore(stud_id);
    }

    //Получить финальную отметку
    //Пример запроса: /score/final?std_id=51
    //Испульзует ROUND (PostgreSQL) для округления значения
    @GetMapping(value = "/final", produces = "application/json")
    public List<Integer> finalScore (@RequestParam("std_id") Long stud_id){
        return courseCompletionImplements.finalScore(stud_id);
    }
}

