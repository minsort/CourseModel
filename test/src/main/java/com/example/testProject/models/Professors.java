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
@Table(name = "professors")

public class Professors {

    @Id
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Float pay;


    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prof_course",
            joinColumns = @JoinColumn(name = "prof_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses=new ArrayList<Course>();



}
