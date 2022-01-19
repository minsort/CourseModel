package com.example.testProject.report;

import com.example.testProject.repository.ProfessorsRepository;
import com.example.testProject.repository.StudentsRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class ServiceProfForReport {

    private final ProfessorsRepository professorsRepository;
    public ServiceProfForReport( ProfessorsRepository professorsRepository, StudentsRepository studentsRepository) {
        this.professorsRepository = professorsRepository;
        this.studentsRepository = studentsRepository; }
    final StudentsRepository studentsRepository;


    public MainClass listAll(@Param("prof_id") Long prof_id) {

        MainClass list = new MainClass(studentsRepository.nameProf(prof_id),
                studentsRepository.totalStudents(prof_id),
                studentsRepository.averagePerformance(prof_id));
        return list;
    }

// Работает только findAll(). Как я только не пытался
// использовать свои методы с @NativeQuery из StudentsRepository и ProfessorsRepository- и ничего(((
// Итог - : SQL Error: 1054, SQLState: 42S22
//2021-12-12 22:10:24.876 ERROR 4861 --- [nio-8080-exec-2]
// o.h.engine.jdbc.spi.SqlExceptionHelper:
// No such column: 'id'. 'id' must be in [count(distinct students.name),
}