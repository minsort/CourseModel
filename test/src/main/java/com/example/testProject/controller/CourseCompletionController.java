
package com.example.testProject.controller;


import com.example.testProject.models.CourseCompletion;
import com.example.testProject.repository.CourseCompletionRepository;
import com.example.testProject.service.CourseCompletionImplements;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class CourseCompletionController {


    final
    CourseCompletionImplements courseCompletionImplements;

    final
    CourseCompletionRepository courseCompletionRepository;

    public CourseCompletionController( CourseCompletionImplements courseCompletionImplements,
                                       CourseCompletionRepository courseCompletionRepository) {
        this.courseCompletionImplements = courseCompletionImplements;
        this.courseCompletionRepository = courseCompletionRepository;
    }


    @GetMapping("/avg")
    public String avg(){

        return courseCompletionRepository.avgScores();   //Получить текущий средний балл
    }


    @GetMapping("/end")                                 //Финальная отметка
    public Integer end (){

        return courseCompletionRepository.endScores();
    }

                                                        // Курсы прослушенные студентом

@GetMapping(value = "/course", produces = "application/json")
    public List<CourseCompletion> allCourse (@RequestParam (required=false) String students_name){
    // List<CourseCompletion> list =
           return courseCompletionRepository.allCourseStudent("students_name");


}



}

