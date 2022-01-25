package com.example.testProject.controller;

import com.example.testProject.models.Professor;
import com.example.testProject.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class ProfessorController {
private final ProfessorService professorService;
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    //Главная страница
    @GetMapping("/prof")
    public String profMain(Model model){
        log.info("Запрашиваем главную страницу");
        return "index.html";}

    //Добавляет нового профессора - для фронденда
    @PostMapping("/add")
    public String addProfessors (@RequestParam String name, Model model){
        log.info("Добавляем нового профессора с именем :{}",name);
        Professor professor = new Professor(name);
        professorService.addProfessors(professor);
        return "redirect:/allGood.html"; }

        //Удаляет профессора - для фронтенда
    @PostMapping("/delete")
    public String profDelete(@RequestParam Long id, Model model){
        log.info("Удаляем профессора с ID ={}",id);
        professorService.delProf(id);
    return "redirect:/profDellSucc.html";}
}
