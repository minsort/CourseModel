/*
При реализации данного проэкта, в силу не большой бизнесс-логики, потребность в Service-слоях отсутствует,
однако, он здесь для сохранения хорошего тона и возможности дальнейшего "апгрейда"
*/

package com.example.testProject.service;
import com.example.testProject.repository.StudentsRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public class StudentsServiceImplements {

    final
    StudentsRepository studentsRepository;

    public StudentsServiceImplements(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    //Добавление студента
    public void saver(@Param(value = "name") String name) {
studentsRepository.addStudent(name);
    }

    public void deleter(Long id) {  //Удаление студента по Id
studentsRepository.deleteById(id);
    }   //Удаление студента
}
