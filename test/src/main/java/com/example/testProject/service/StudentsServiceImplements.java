/*
При реализации данного проэкта, в силу не большой бизнесс-логики, потребность в Service-слоях отсутствует,
однако, он здесь для сохранения хорошего тона и возможности дальнейшего "апгрейда"
*/

package com.example.testProject.service;
import com.example.testProject.models.Students;
import com.example.testProject.repository.StudentsRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentsServiceImplements implements StudentsService {

    final
    StudentsRepository studentsRepository;

    public StudentsServiceImplements(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public void saver(Students students) {
studentsRepository.saveAndFlush(students);
    } //Добавление студента

    @Override
    public void deleter(Long id) {  //Удаление студента по Id
studentsRepository.deleteById(id);
    }   //Удаление студента





}
