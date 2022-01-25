package com.example.testProject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
        @Id
        private Long id;
        private String name;
        private int number;
        private float cost;

        @OneToMany (cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id")
        private List<StudCourse> ccc = new ArrayList<StudCourse>();

        @OneToMany (cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id")
        private List<ProfCourse> ppp = new ArrayList<ProfCourse>();

}
