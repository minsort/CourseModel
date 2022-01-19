package com.example.testProject.repository;

import com.example.testProject.models.Students;
import com.example.testProject.report.MainClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {

    @Query(value = "select professors.name from professors where professors.id= :prof_id", nativeQuery = true)
    String nameProf(@Param("prof_id") Long prof_id);

    //Общее колличество студентов по всем курсам, где профессор - :prof_id
    @Query(value = "select count (distinct(students.name)) from students\n" +
            "inner join stud_course on students.id = stud_course.students_id\n" +
            "inner join course on stud_course.course_id = course.id\n" +
            "inner join prof_course on course.id = prof_course.course_id\n" +
            "inner join professors on prof_course.prof_id = :prof_id",nativeQuery = true)
    String totalStudents(@Param("prof_id") Long prof_id);

    //Средняя успеваемость всех студентов, у которых профессор - :prof_id
    @Query(value = "select AVG(students.studentperformance) from students\n" +
            "inner join stud_course on students.id = stud_course.students_id\n" +
            "inner join course on stud_course.course_id = course.id\n" +
            "inner join prof_course on course.id = prof_course.course_id\n" +
            "inner join professors on prof_course.prof_id = :prof_id", nativeQuery = true)
    String averagePerformance(@Param("prof_id") Long prof_id);
}
