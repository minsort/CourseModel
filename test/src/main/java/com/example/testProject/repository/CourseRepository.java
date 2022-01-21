package com.example.testProject.repository;

import com.example.testProject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long>{
    //Получает список прослушенных курсов
    @Query(value = "select name from course inner join stud_course on course.id=stud_course.course_id\n" +
            "and stud_course.students_id=:std_id",nativeQuery = true)
    List<String> allCoursesOfStudents(@Param("std_id") Long students_id);

}
