package com.example.testProject.report;

import com.example.testProject.models.Professors;
import com.example.testProject.repository.ProfessorsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceProfForReport {

    private final ProfessorsRepository professorsRepository;


    public ServiceProfForReport(ProfessorsRepository professorsRepository) {
        this.professorsRepository = professorsRepository;
    }

    public List<Professors> listAll() {
        return professorsRepository.findAll(Sort.by("name").ascending());
    }

}