package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "prof_course")
public class ProfCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "prof_id")
    private Professor professor;

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
}
