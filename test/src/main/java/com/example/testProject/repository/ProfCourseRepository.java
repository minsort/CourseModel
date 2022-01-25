package com.example.testProject.repository;

import com.example.testProject.models.ProfCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfCourseRepository extends JpaRepository<ProfCourse, Long> {

}
