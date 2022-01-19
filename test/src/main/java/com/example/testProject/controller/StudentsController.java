package com.example.testProject.controller;

import com.example.testProject.models.Stud_Course;
import com.example.testProject.models.Students;
import com.example.testProject.repository.Stud_courseRepository;
import com.example.testProject.repository.StudentsRepository;
import com.example.testProject.service.StudentsServiceImplements;
import com.example.testProject.service.StudСourseImplements;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/students")
public class StudentsController {
    final StudentsRepository studentsRepository;
    final StudentsServiceImplements studentsServiceImplements;

    public StudentsController(StudСourseImplements studСourseImplements,
                              Stud_courseRepository studCourseRepository,
                              StudentsRepository studentsRepository,
                              StudentsServiceImplements studentsServiceImplements) {
        this.studentsRepository = studentsRepository;
        this.studentsServiceImplements = studentsServiceImplements;
    }

//Записывает нового студента в таблицу students.
//пример запроса: /students/new
// Нового студента передаем в теле запроса (JSON)
//Протестирован в Postman
    @PostMapping("/new")
    protected void addStudents(@RequestBody Students students){
        studentsServiceImplements.save(students);
    }






}