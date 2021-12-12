package com.example.testProject.controller;

import com.example.testProject.repository.StudentsRepository;
import com.example.testProject.service.StudentsServiceImplements;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(path="/students")
public class StudentsController {

    final
    StudentsServiceImplements studentsServiceImplements;

    public StudentsController(StudentsServiceImplements studentsServiceImplements, StudentsRepository studentsRepository) {
        this.studentsServiceImplements = studentsServiceImplements;

    }

//Добавляет нового студента в таблицу students.
//ример запроса: /students/new?name=Oleg
//Протестирован в браузере
    @GetMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    protected void addStudents(@RequestParam String name) {
        studentsServiceImplements.saver(name);
    }

//Удаляет студента по Id
// Пример запроса: /students/delete?id=1
//Протестирован на Postman
    @DeleteMapping(value = "/delete")
    public void deleteStudents(@RequestParam(value="id") Long id){
        studentsServiceImplements.deleter(id);
    }

}