package com.example.testProject.controller;

import com.example.testProject.models.Student;
import com.example.testProject.service.StudentService;
import com.example.testProject.service.StudСourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/students")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudСourseService studСourseService,
                             StudentService studentService) {
        this.studentService = studentService;}

//Записывает нового студента в таблицу student.
//пример запроса: /student/new
// Нового студента передаем в теле запроса (JSON)
//Протестирован в Postman
    @PostMapping("/new")
    protected void addStudents(@RequestBody Student student){
        log.info("Добавляет нового студента :{}",student);
        studentService.save(student);
    }
}