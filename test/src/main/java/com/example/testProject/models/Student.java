package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String numberPhone;
    private String email;
    private Integer recordBook; //номер зачетки
    private Float studentPerformance; //Средняя успеваемость

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "students_id")
    private List<StudCourse> aaa = new ArrayList<StudCourse>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "stud_id")
    private List<CourseCompletion> comments=new ArrayList<CourseCompletion>();
}
