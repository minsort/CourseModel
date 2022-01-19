package com.example.testProject.controller;

import com.example.testProject.repository.StudentsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*Тестирование отдельных запросов SQL для отчета*/
@RestController
@RequestMapping("/test")
public class testController {
/*
final StudentsRepository studentsRepository;
    public testController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
//Рабочий - суммарное колличество студентов по всем курсам определенного профессора
    @GetMapping(value = "/st", produces = "application/json")
    public List<Integer> allCourse (@RequestParam("prof_id") Long prof_id){
        return studentsRepository.totalStudents(prof_id);
    }

    @GetMapping(value = "/sc", produces = "application/json")
    public List<Float> alCourse (@RequestParam("prof_id") Long prof_id){
        return studentsRepository.averagePerformance(prof_id);
    }

*/



}
