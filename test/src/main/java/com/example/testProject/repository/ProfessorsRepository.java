package com.example.testProject.repository;


import com.example.testProject.models.Professors;
import com.example.testProject.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorsRepository extends JpaRepository<Professors, String> {
}
