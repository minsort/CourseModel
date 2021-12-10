package com.example.testProject.repository;

import com.example.testProject.models.CourseCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseCompletionRepository extends JpaRepository <CourseCompletion, Long> {



    @Query(value = "SELECT AVG (score) FROM coursecompletion WHERE students_id= 1 ", nativeQuery = true)
    public String avgScores ();

    @Query(value = "SELECT AVG (score) FROM coursecompletion WHERE students_id =1 " , nativeQuery = true)
    public Integer endScores ();

    @Query(value = "SELECT course_id FROM stud_course WHERE stud_id= :students_name", nativeQuery = true)
    List<CourseCompletion> allCourseStudent(@Param("students_name") String students_name);


















   /* @Query(value = "INSERT INTO stud_course VALUES(students_name= :students_name, course_name= :course_name)", nativeQuery = true)
    void addOnCourse();*/




















}
