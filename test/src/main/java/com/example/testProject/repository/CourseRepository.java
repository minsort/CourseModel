package com.example.testProject.repository;


import com.example.testProject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Long>{
}
