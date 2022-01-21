package com.example.testProject.controller;

import com.example.testProject.models.Professors;
import com.example.testProject.service.ProfessorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@Controller
public class FrontendController {
final ProfessorsService professorsService;
    public FrontendController(ProfessorsService professorsService) {
        this.professorsService = professorsService;
    }

    //Главная страница
    @GetMapping("/prof")
    public String profMain(Model model){
        return "index.html";}

    //Добавляет нового профессора - для фронденда
    @PostMapping("/add")
    public String addProfessors (@RequestParam String name, Model model){
        Professors professors = new Professors(name);
        professorsService.addProfessors(professors);
        return "redirect:/allGood.html"; }

        //Удаляет профессора - для фронтенда
    @PostMapping("/delete")
    public String profDelete(@RequestParam Long id, Model model){
        professorsService.delProf(id);
    return "redirect:/profDellSucc.html";}

















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
