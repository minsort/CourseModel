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
@Table(name = "professors")

public class Professors {
    @Id
    private String name;
    private String address;
    private String phone;
    private Float pay;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "prof_course",
            joinColumns = @JoinColumn(name = "professor_name"),
            inverseJoinColumns = @JoinColumn(name = "course_name"))
    private List<Course> courses;



}
