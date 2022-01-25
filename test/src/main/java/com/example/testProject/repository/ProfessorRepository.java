package com.example.testProject.repository;

import com.example.testProject.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
ProfessorRepository countProfessorsBy = null;

    //Для .XLSX отчета
    // ФИО профессора, для которого будет осуществлятся поиск его студентов
    @Query(value = "select professors.name from professors where professors.id= :prof_id", nativeQuery = true)
    String nameProf(@Param("prof_id") Long prof_id);

    //Удаляет профессора - для фронтенда
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from professors" +
            " where professors.id= :id", nativeQuery = true)
    void delProf(@Param ("id") Long id);


}
