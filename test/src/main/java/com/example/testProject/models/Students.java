package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String numberPhone;
    private String email;
    private Integer recordBook; //номер зачетки
    private float studentPerformance; //Средняя успеваемость


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<CourseCompletion> comments=new ArrayList<CourseCompletion>();

/*

    @ManyToOne(fetch = FetchType.LAZY)
    private CourseCompletion courseCompletion;
*/



















}
