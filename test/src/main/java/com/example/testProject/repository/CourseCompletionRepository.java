package com.example.testProject.repository;

import com.example.testProject.models.CourseCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCompletionRepository extends JpaRepository <CourseCompletion, Long> {

//Получить текущий средний бал студента
    @Query(value = "SELECT AVG (score) FROM coursecompletion WHERE coursecompletion.stud_id= :std_id", nativeQuery = true)
    List<Float> averageScore(@Param("std_id") Long students_id);

    //Получить финальную отметку
    @Query(value = "SELECT round(AVG (score)) FROM coursecompletion WHERE coursecompletion.stud_id= :std_id", nativeQuery = true)
    List<Integer> finalScore(@Param("std_id") Long students_id);
}
