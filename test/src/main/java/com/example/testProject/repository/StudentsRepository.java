package com.example.testProject.repository;

import com.example.testProject.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {

// Добавление нового студента

    @Query(value = "insert into students (name) values (:name)", nativeQuery = true)
    Students addStudent(@Param("name") String name);

    //REPORT
    //Общее колличество студентов по всем курсам, где профессор - :id

    @Query(value = "select count(distinct students.name) from students " +
            "inner join stud_course on students.id = stud_course.stud_id " +
            "inner join course on stud_course.course_id = course.id " +
            "inner join prof_course on course.id = prof_course.course_id " +
            "inner join professors on prof_course.prof_id = :id",nativeQuery = true)
    List<Students> total(@Param("id") Long id);

    //REPORT
    //Средняя успеваемость всех студентов, у которых профессор - :id

    @Query(value = "select AVG(students.student_performance) from students " +
            "INNER JOIN stud_course ON students.id = stud_course.stud_id " +
            "INNER JOIN course ON stud_course.course_id = course.id " +
            "INNER JOIN prof_course ON course.id = prof_course.course_id " +
            "INNER JOIN professors ON prof_course.prof_id = :id", nativeQuery = true)
    List<Students>  performance(@Param("id") Long id);



}
