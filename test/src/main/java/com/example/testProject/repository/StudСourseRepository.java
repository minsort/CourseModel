package com.example.testProject.repository;

import com.example.testProject.models.StudCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudСourseRepository extends JpaRepository<StudCourse, Long> {
    //Удаляет студента с курса
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from stud_course" +
            " where stud_course.students_id= :std_id and stud_course.course_id= :crs_id", nativeQuery = true)
    void delStudentsFromCourse(@Param("std_id") Long students_id, @Param("crs_id") Long course_id);

//Записывает студента на курс
    @Transactional
    @Modifying
    @Query(value = "insert into stud_course (students_id, course_id) values ( :std_id," +
            " :crs_id)", nativeQuery = true)
    void addStudentsOnCourse(@Param("std_id") Long students_id, @Param("crs_id") Long course_id);








}