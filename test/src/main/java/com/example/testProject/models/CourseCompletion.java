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
@Table(name = "coursecompletion")
public class CourseCompletion {
    @Id
    private Long id;
    private Integer score;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="course_id")
    private Course course;

//Рабочее!!!
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="stud_id")
    private Students students;

}
