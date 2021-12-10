package com.example.testProject.service;

import com.example.testProject.models.Students;
import org.springframework.stereotype.Service;


@Service
public interface StudentsService {

    void saver (Students students);
    void deleter (Long id);
}
