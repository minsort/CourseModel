package com.example.testProject.repository;

import com.example.testProject.models.Professors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProfessorsRepository extends JpaRepository<Professors, Long>{
ProfessorsRepository countProfessorsBy = null;

    //Для .XLSX отчета
    // ФИО профессора, для которого будет осуществлятся поиск его студентов
    @Query(value = "select name from professors where professors.id= :id", nativeQuery = true)
    List<Professors> findByNames(@Param("id")Long id);

    //Удаляет профессора - для фронтенда
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from professors" +
            " where professors.id= :id", nativeQuery = true)
    void delProf(@Param ("id") Long id);


}
