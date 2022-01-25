package com.example.testProject.service;

import com.example.testProject.models.Professor;
import com.example.testProject.repository.ProfessorRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ProfessorService {
final ProfessorRepository professorRepository;
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
//Добавление профессора - для фронтенда
    @Modifying
    public void addProfessors (Professor professor){
        professorRepository.save(professor);
}

    //Удаляет профессора - для фронтенда
    public void delProf (@RequestParam ("id") Long id){
        professorRepository.delProf(id);
    }
}
