package com.example.testProject.repository;


import com.example.testProject.models.Professors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorsRepository extends JpaRepository<Professors, Long>{

//REPORT
    // ФИО профессора, для которого будет осуществлятся поиск его студентов

    @Query(value = "select name from professors where professors.id= :id", nativeQuery = true)
    List<Professors> findByNames(@Param("id")Long id);























}
