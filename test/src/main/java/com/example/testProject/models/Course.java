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
@Table(name = "course")

public class Course {

        @Id
        private Long id;
        private String name;
        private int number;
        private float cost;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "stud_course",
                joinColumns = @JoinColumn(name = "stud_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
        private List<Students> iStudent=new ArrayList<Students>();

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "prof_course",
                joinColumns = @JoinColumn(name = "prof_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
        private List<Professors> iProf=new ArrayList<Professors>();




}
