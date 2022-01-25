package com.example.testProject.service;

import com.example.testProject.report.TotalStatistics;
import com.example.testProject.repository.ProfessorRepository;
import com.example.testProject.repository.StudentRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class ProfForReportService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    public ProfForReportService(ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository; }

    public TotalStatistics listAll(@Param("prof_id") Long prof_id) {

        TotalStatistics list = new TotalStatistics(professorRepository.nameProf(prof_id),
                studentRepository.totalStudents(prof_id),
                studentRepository.averagePerformance(prof_id));
        return list;
    }
}