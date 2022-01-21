package com.example.testProject.service;

import com.example.testProject.models.Professors;
import com.example.testProject.repository.ProfessorsRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProfessorsService {
final ProfessorsRepository professorsRepository;
    public ProfessorsService(ProfessorsRepository professorsRepository) {
        this.professorsRepository = professorsRepository;
    }
//Добавление профессора - для фронтенда
    @Modifying
    public void addProfessors (Professors professors){
    professorsRepository.save(professors);
}

    //Удаляет профессора - для фронтенда
    public void delProf (@RequestParam ("id") Long id){
        professorsRepository.delProf(id);
    }




}
