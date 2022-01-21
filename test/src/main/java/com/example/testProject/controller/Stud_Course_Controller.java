package com.example.testProject.controller;

import com.example.testProject.models.Stud_Course;
import com.example.testProject.repository.Stud_courseRepository;
import com.example.testProject.service.StudСourseImplements;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/course")
public class Stud_Course_Controller {
    final Stud_courseRepository stud_courseRepository;
    final StudСourseImplements studСourseImplements;
    public Stud_Course_Controller(Stud_courseRepository stud_courseRepository,
                                  StudСourseImplements studСourseImplements) {
        this.stud_courseRepository = stud_courseRepository;
        this.studСourseImplements = studСourseImplements;
    }

//Не работает - возвращает код 200 ОК, а по факту добавляет NULL
    @PostMapping("/ad")
    protected void onCourse(@RequestBody Stud_Course stud_course){
        studСourseImplements.save(stud_course);
    }
//Удаляет студента с курса
//По сути - удаляет связь из связывающей таблицы (Студенты и Курсы)
//Пример запроса: /course/delete?std_id=51&crs_id=1
    @DeleteMapping("/delete")
    public void studDeleteFromCourse(@RequestParam(name="std_id") Long students_id,
             @RequestParam("crs_id") Long course_id) {
        studСourseImplements.delStudentsFromCourse(students_id,course_id);
    }
//Записывает студента на курс
// добавляет строку в связывающую таблицу (Студенты и Курсы)
//Пример запроса: /course/add?std_id=51&crs_id=2
    @GetMapping("/add")
    public void addStudentOnCourse(@RequestParam(name="std_id") Long students_id,
                                     @RequestParam("crs_id") Long course_id) {
        studСourseImplements.addStudentOnCourse(students_id,course_id);
    }
}
