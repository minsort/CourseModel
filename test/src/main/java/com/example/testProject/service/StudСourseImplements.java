package com.example.testProject.service;

import com.example.testProject.models.Stud_Course;
import com.example.testProject.repository.Stud_courseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudСourseImplements{
    final Stud_courseRepository stud_courseRepository;
    public StudСourseImplements(Stud_courseRepository stud_courseRepository) {
        this.stud_courseRepository = stud_courseRepository;
    }
    //Не рабочий - записывает NULL
    //Записывает студента на курс
    @Modifying(clearAutomatically = true)
    public void save (Stud_Course stud_course){
        stud_courseRepository.save(stud_course);
    }

    //Записывает студента на курс
    public void addStudentOnCourse(@RequestParam(name="std_id") Long students_id,
                                   @RequestParam("crs_id") Long course_id) {
        stud_courseRepository.addStudentsOnCourse(students_id,course_id);
    }

    //Удаляет студента с курса
    public void delStudentsFromCourse (@RequestParam(name="std_id") Long students_id,
                                       @RequestParam("crs_id") Long course_id){
        stud_courseRepository.delStudentsFromCourse(students_id, course_id);
    }

}
