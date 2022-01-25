package com.example.testProject.service;

import com.example.testProject.repository.StudСourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudСourseService {
    private final StudСourseRepository stud_сourseRepository;
    public StudСourseService(StudСourseRepository stud_сourseRepository) {
        this.stud_сourseRepository = stud_сourseRepository;
    }

    //Записывает студента на курс
    public void addStudentOnCourse(@RequestParam(name="std_id") Long students_id,
                                   @RequestParam("crs_id") Long course_id) {
        stud_сourseRepository.addStudentsOnCourse(students_id,course_id);
    }

    //Удаляет студента с курса
    public void delStudentsFromCourse (@RequestParam(name="std_id") Long students_id,
                                       @RequestParam("crs_id") Long course_id){
        stud_сourseRepository.delStudentsFromCourse(students_id, course_id);
    }
}
