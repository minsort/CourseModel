package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String numberPhone;
    private String email;
    private Integer recordBook; //номер зачетки
    private float studentPerformance; //Средняя успеваемость


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stud_course",
    joinColumns = @JoinColumn(name = "students_name"),
    inverseJoinColumns = @JoinColumn(name = "course_name"))
    private List<Course> courses;



}
