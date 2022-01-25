package com.example.testProject.controller;

import com.example.testProject.service.StudСourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/course")
public class StudCourseController {
    private final StudСourseService studСourseService;
    public StudCourseController(StudСourseService studСourseService) {
        this.studСourseService = studСourseService;}

//Удаляет студента с курса
//По сути - удаляет связь из связывающей таблицы (Студенты и Курсы)
//Пример запроса: /course/delete?std_id=51&crs_id=1
    @DeleteMapping("/delete")
    public void studDeleteFromCourse(@RequestParam(name="std_id") Long students_id,
             @RequestParam("crs_id") Long course_id) {
        log.info("Удаляет студента с ID = {} с курса c ID = {}",students_id, course_id);
        studСourseService.delStudentsFromCourse(students_id,course_id);
    }
//Записывает студента на курс
// добавляет строку в связывающую таблицу (Студенты и Курсы)
//Пример запроса: /course/add?std_id=51&crs_id=2
    @GetMapping("/add")
    public void addStudentOnCourse(@RequestParam(name="std_id") Long students_id,
                                     @RequestParam("crs_id") Long course_id) {
        log.info("Добавляет студента с ID = {} на курс с ID = {}",students_id, course_id);
        studСourseService.addStudentOnCourse(students_id,course_id);
    }
}
