package com.example.testProject.repository;

import com.example.testProject.models.Prof_Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Prof_CourseRepository extends JpaRepository<Prof_Course, Long> {

}
