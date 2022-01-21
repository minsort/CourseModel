package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "stud_course")
public class Stud_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "students_id")
    private Students students;

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
}
