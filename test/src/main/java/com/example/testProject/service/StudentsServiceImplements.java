/*
При реализации данного проэкта, в силу не большой бизнесс-логики, потребность в Service-слоях отсутствует,
однако, он здесь для сохранения хорошего тона и возможности дальнейшего "апгрейда"
*/

package com.example.testProject.service;
import com.example.testProject.models.Students;
import com.example.testProject.repository.StudentsRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class StudentsServiceImplements {
    final
    StudentsRepository studentsRepository;
    public StudentsServiceImplements(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
    //Добавление студента в таблицу студентов
    public void save (Students students){
        studentsRepository.save(students);
    }



}
