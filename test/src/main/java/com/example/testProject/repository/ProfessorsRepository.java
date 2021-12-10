package com.example.testProject.repository;


import com.example.testProject.models.Professors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorsRepository extends JpaRepository<Professors, Long>{

    @Query(value = "select professors.name from professors", nativeQuery = true)
    List<Professors> findByName(String name);




    /*@NamedQuery(name = "Professors.findByNames",
            query = "select name from Professors")*/





/*
@Query(value = "SELECT professors.name FROM professors", nativeQuery = true)

*/













}
